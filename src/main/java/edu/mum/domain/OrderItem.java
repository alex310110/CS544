package edu.mum.domain;



import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "order_id")
    private Order order;
    private String review;
    @Enumerated(EnumType.STRING)
    private Status reviewStatus = Status.PENDING;
    private int rating = 0;
    @Enumerated(EnumType.STRING)
    private OrderItemStatus orderStatus = OrderItemStatus.ORDERED;
    private LocalDateTime shippingDate;
    private LocalDateTime deliveredDate;
    private LocalDateTime reviewDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Status getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(Status reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public OrderItemStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderItemStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public LocalDateTime getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(LocalDateTime shippingDate) {
		this.shippingDate = shippingDate;
	}
	public LocalDateTime getDeliveredDate() {
		return deliveredDate;
	}
	public void setDeliveredDate(LocalDateTime deliveredDate) {
		this.deliveredDate = deliveredDate;
	}
	public LocalDateTime getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(LocalDateTime reviewDate) {
		this.reviewDate = reviewDate;
	}
    
    
    
}
