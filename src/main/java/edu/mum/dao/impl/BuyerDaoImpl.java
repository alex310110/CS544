package edu.mum.dao.impl;

import edu.mum.domain.Buyer;
import edu.mum.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class BuyerDaoImpl extends GenericDaoImpl<Buyer> implements edu.mum.dao.BuyerDao {
    public BuyerDaoImpl() {
        super.setDaoType(Buyer.class );
    }

    @Override
    public Buyer findBuyerByUser(User user) {
        Query query = entityManager.createNamedQuery("Buyer.findByUser").setParameter("user", user);

        return (Buyer) query.getSingleResult();
    }
}
