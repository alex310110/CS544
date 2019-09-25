package edu.mum.dao.impl;

import edu.mum.domain.CartItem;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CartItemDaoImpl extends GenericDaoImpl<CartItem> implements edu.mum.dao.CartItemDao {
    public CartItemDaoImpl() {
        super.setDaoType(CartItem.class );
    }

    @Override
    public List<CartItem> getCartItemByBuyerId(Long buyerId) {
        Query query = entityManager.createNamedQuery("CartItem.findByUserId").setParameter("buyerId", buyerId);

        return (List<CartItem>) query.getResultList();
    }
}
