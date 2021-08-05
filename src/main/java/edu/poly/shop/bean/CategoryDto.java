package edu.poly.shop.bean;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Serializable {
	
	private Long categoryId;
	@NotEmpty
	@Length(min=4)
	private String name;
	
	private Boolean isEdit=false;
}
