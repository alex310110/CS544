package edu.mum.service.impl;

import edu.mum.dao.CartItemDao;
import edu.mum.domain.Buyer;
import edu.mum.domain.CartItem;
import edu.mum.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartItemDao cartItemDao;

    @Override
    public void addCartItem(CartItem item) {
        cartItemDao.save(item);
    }

    @Override
    public CartItem saveCartItem(Buyer buyer, CartItem item) {
        item.setBuyer(buyer);
        buyer.addCartItem(item);
        return cartItemDao.save(item);
    }

    @Override
    public void removeCartItem(Long id) {
        CartItem item = cartItemDao.findOne(id);
        item.getBuyer().removeCartItem(item);
        cartItemDao.delete(item.getId());
    }

    @Override
    public List<CartItem> getCartByBuyerId(Long buyerId) {
        return (List) cartItemDao.getCartItemByBuyerId(buyerId);
    }

    @Override
    public BigDecimal getTotalAmount(Long buyerId) {
        List<CartItem> cartItems = (List) cartItemDao.getCartItemByBuyerId(buyerId);
        BigDecimal totalAmount = new BigDecimal(0.00);
        for (CartItem ci : cartItems) {
            totalAmount = totalAmount.add(ci.getProduct().getPrice().multiply(new BigDecimal(ci.getQuantity())));
        }
        return totalAmount;
    }
}
