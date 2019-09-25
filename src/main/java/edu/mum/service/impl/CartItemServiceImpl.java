package edu.mum.service.impl;

import edu.mum.dao.CartItemDao;
import edu.mum.domain.CartItem;
import edu.mum.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemDao cartItemDao;

    @Override
    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemDao.save(cartItem);
    }

    @Override
    public List<CartItem> getCartItems() {
        return (List<CartItem>) cartItemDao.findAll();
    }

    @Override
    public CartItem getCartItemById(Long id) {
        return cartItemDao.findOne(id);
    }
}
