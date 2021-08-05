package edu.poly.shop.domain;



import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="accounts")
public class Account implements Serializable{
	@Id
	@Column(length = 30)
	String username;
	@Column(length = 60,nullable = false)
	private String password;
	@JsonIgnore
	@OneToMany(mappedBy ="account",cascade = javax.persistence.CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Authorities>authorities;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;
	
}
