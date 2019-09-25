package edu.mum.dao.impl;

import edu.mum.domain.Seller;
import edu.mum.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class SellerDaoImpl extends GenericDaoImpl<Seller> implements edu.mum.dao.SellerDao {
    public SellerDaoImpl() {
        super.setDaoType(Seller.class );
    }

    @Override
    public Seller findSellerByUser(User user) {
        Query query = entityManager.createQuery("select s from Seller s where s.user = :user ");
        try {
            return (Seller) query.setParameter("user", user).getSingleResult();
        } catch(Exception e){
            return null;
        }
    }
}
