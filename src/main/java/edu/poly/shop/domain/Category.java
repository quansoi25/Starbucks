package edu.poly.shop.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Categories")
public class Category implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 Long categoryId;
	@Column(name="category_name",length = 100,columnDefinition = "nvarchar(100)")
	public String name;
	@OneToMany(mappedBy ="category",cascade = javax.persistence.CascadeType.ALL)
	 private Set<Product> products;
}
