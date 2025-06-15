package com.app.performance;

// pro
enum ProductCategory {
	FOOD, DRINK, DEVICE, APPLIANCE, STATIONARY, FURNITURE
	
	
	
}

public class Product {

	private Long id;
	private String name;
	private String productId;
	private ProductCategory prodCatId;

	public Product(Long id, String name, String productId, ProductCategory prodCatId) {
		super();
		this.id = id;
		this.name = name;
		this.productId = productId;
		this.prodCatId = prodCatId;
	}

	public Product() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public ProductCategory getProdCatId() {
		return prodCatId;
	}

	public void setProdCatId(ProductCategory prodCatId) {
		this.prodCatId = prodCatId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", productId=" + productId + ", prodCatId=" + prodCatId + "]";
	}
	
	
	

}
