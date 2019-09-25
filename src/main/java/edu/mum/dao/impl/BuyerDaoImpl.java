package edu.mum.dao.impl;

import edu.mum.domain.Buyer;
import edu.mum.domain.Product;
import edu.mum.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class BuyerDaoImpl extends GenericDaoImpl<Buyer> implements edu.mum.dao.BuyerDao {
    public BuyerDaoImpl() {
        super.setDaoType(Buyer.class);
    }

    @Override
    public Buyer findBuyerByUser(User user) {
        Query query = entityManager.createQuery("select b from Buyer b where b.user = :user ");
        try {
            return (Buyer) query.setParameter("user", user).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
