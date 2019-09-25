package edu.mum.domain.view;


import java.math.BigDecimal;


public class CartInfo {
    private Long id;
    private String productName;
    private BigDecimal productPrice;
    private String picture;
    private int quantity;
	public CartInfo(Long id2, String name, BigDecimal price, String image, int quantity2) {
		// TODO Auto-generated constructor stub
		this.id = id2;
		this.productName = name;
		this.productPrice = price;
		this.picture = image;
		this.quantity = quantity2;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    
}
