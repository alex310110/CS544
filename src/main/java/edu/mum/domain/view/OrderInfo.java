package edu.mum.domain.view;

import edu.mum.domain.Buyer;
import edu.mum.domain.OrderItem;
import edu.mum.domain.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderInfo {
    private Long id;
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();
    private BigDecimal totalAmount = new BigDecimal(0.00);
    private Buyer buyer;
    private String shippingAddress;
    private String billingAddress;
    private String paymentMethod;
    private String paymentInfo;
    private OrderStatus status = OrderStatus.NEW;
    private LocalDateTime orderedDate;
    private LocalDateTime endDate;
    private Boolean usingPoints = false;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public LocalDateTime getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(LocalDateTime orderedDate) {
		this.orderedDate = orderedDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public Boolean getUsingPoints() {
		return usingPoints;
	}
	public void setUsingPoints(Boolean usingPoints) {
		this.usingPoints = usingPoints;
	}
	
    
    
}
