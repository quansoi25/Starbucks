package edu.poly.shop.controller;

import java.io.IOException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.bean.CategoryDto;
import edu.poly.shop.bean.ProductDto;
import edu.poly.shop.domain.Category;
import edu.poly.shop.domain.Product;
import edu.poly.shop.service.CategoryService;
import edu.poly.shop.service.ProductService;
import edu.poly.shop.service.StorageService;

@Controller
@RequestMapping("admin/products")
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService cs;	
	@Autowired
	StorageService storageservice;
	@ModelAttribute("categories")
	public List<CategoryDto> getCategories(){
		return cs.findAll().stream().map(item->{
			CategoryDto dto=new CategoryDto();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).collect(Collectors.toList());
		
	}
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("product",new ProductDto());
		return"admin/products/addOrEdit";
	}
	@GetMapping("edit/{productId}")
	public ModelAndView edit(ModelMap model,@PathVariable("productId") long productId) {
		Optional<Product> opt= productService.findById(productId);
		ProductDto dto=new ProductDto();
		if(opt.isPresent()) {
			Product entity=opt.get();
			BeanUtils.copyProperties(entity, dto);	
			dto.setCategoryId(entity.getCategory().getCategoryId());
			dto.setIsEdit(true);
			model.addAttribute("product", dto);
			return new ModelAndView("admin/products/addOrEdit",model);
				}
		model.addAttribute("message", "product is not existed");
		return new ModelAndView("redirect:/admin/products",model);
	}
	@GetMapping("/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename){
		Resource file=storageservice.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+file.getFilename()+"\"").body(file);
	}
	@GetMapping("delete/{productId}")
	public ModelAndView delete(ModelMap model,@PathVariable("productId") Long productId) throws IOException {
		Optional<Product> opt=productService.findById(productId);
		if(opt.isPresent()) {
			if(!StringUtils.isEmpty(opt.get().getImage())) {
				storageservice.delete(opt.get().getImage());
			}
			productService.delete(opt.get());
			model.addAttribute("message","Product is delete");
		}else {
			model.addAttribute("message","Product is not Found");
		}
		return new ModelAndView("forward:/admin/products",model);
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, 
			@Valid @ModelAttribute("product") ProductDto dto,BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("admin/products/addOrEdit");
		}
		Product entity=new Product();
		BeanUtils.copyProperties(dto, entity);
		Category category=new Category();
		category.setCategoryId(dto.getCategoryId());
		entity.setCategory(category);
		if(!dto.getImageFile().isEmpty()) {
			UUID uuid=UUID.randomUUID();
			String uuString=uuid.toString();
			entity.setImage(storageservice.getStoredFileName(dto.getImageFile(),uuString));
			storageservice.store(dto.getImageFile(),entity.getImage());
		}
		productService.save(entity);
		model.addAttribute("message","Product is save");
		return new ModelAndView("forward:/admin/products",model);
	}
	@RequestMapping("")
	public String list(ModelMap model,CategoryDto dto) {
		List<Product> list=productService.findAll();
		model.addAttribute("products", list);
		return "admin/products/list";
	}
	@GetMapping("sreach")
	public String sreach(ModelMap model,@RequestParam (name="name",required = false) String name) {
		List<Category>list=null;
		if(StringUtils.hasText(name)) {
			list=cs.findByNameContaining(name);			
		}else {
			list=cs.findAll();
		}
		model.addAttribute("products", list);
		return"admin/products/sreach";
	}
	@GetMapping("sreachpage")
	public String sreach(ModelMap model,@RequestParam (name="name",required = false) String name,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		int currentPage=page.orElse(1);
		int pageSize=size.orElse(5);
		Pageable pageable=PageRequest.of(currentPage-1,pageSize,Sort.by("name"));
		Page<Category> resultPage=null;
		if(StringUtils.hasText(name)) {
			resultPage=cs.findByNameContaining(name,pageable);		
			model.addAttribute("name", name);
		}else {
			resultPage=cs.findAll(pageable);
		}
		int totalPages=resultPage.getTotalPages();
		if(totalPages>0) {
			int star=Math.max(1,currentPage-2);
			int end=Math.min(currentPage+2,totalPages);
			if (totalPages>5) {
				if(end==totalPages)star=end +5;
				else if(star==1) end=star+5;
			}
			List<Integer>pageNumbers=IntStream.rangeClosed(star, end)
					.boxed()
					.collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		model.addAttribute("categoryPage", resultPage);
		return"admin/products/sreachpage";
	}
}