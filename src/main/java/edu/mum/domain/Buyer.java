package edu.mum.domain;



import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer points = 0;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

	@LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();

	@LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private Set<CartItem> cartItems = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "following", joinColumns = {@JoinColumn(name = "buyer_id")}, inverseJoinColumns = {@JoinColumn(name = "seller_id")})
    private List<Seller> sellers = new ArrayList<Seller>();

    public void followSeller(Seller seller) {
        sellers.add(seller);
    }

    public void unfollowSeller(Seller seller) {
        sellers.remove(seller);
    }

    public void addCartItem(CartItem item) {
        cartItems.add(item);
    }

    public void removeCartItem(CartItem item) {
        cartItems.remove(item);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public List<Seller> getSellers() {
		return sellers;
	}

	public void setSellers(List<Seller> sellers) {
		this.sellers = sellers;
	}
    
    
    
}
