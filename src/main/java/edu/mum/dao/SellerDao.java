package edu.mum.dao;

import edu.mum.domain.Seller;
import edu.mum.domain.User;

public interface SellerDao extends GenericDao<Seller> {
    Seller findSellerByUser(User user);
}
