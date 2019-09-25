package edu.mum.dao;

import edu.mum.domain.CartItem;

import java.util.List;

public interface CartItemDao extends GenericDao<CartItem>{
    public List<CartItem> getCartItemByBuyerId(Long buyerId);
}
