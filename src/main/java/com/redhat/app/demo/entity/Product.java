package com.redhat.app.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="product")
@Data
@NamedQueries({
    @NamedQuery(name="Product.findAll",
                query="SELECT p FROM Product p"),
    @NamedQuery(name="Product.findByName",
				query="SELECT p FROM Product p WHERE p.name LIKE :name"),
	@NamedQuery(name="Product.findByProducts",
                query="SELECT p FROM Product p WHERE p.productId IN (:ids)")				
}) 
public class Product extends AbstractGeneratedIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5602231572577587307L;
	@Column(name="product_id", unique = true)
	private String productId;
	@Column(name = "short_desc")
	private String shortDescription;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private Double price;
	@Column(name="img")
	private String img;
	@Override
	public Long getId() {
		return this.id;
	} 

}
