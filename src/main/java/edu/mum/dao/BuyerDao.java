package edu.mum.dao;

import edu.mum.domain.Buyer;
import edu.mum.domain.User;

public interface BuyerDao extends GenericDao<Buyer>{
    Buyer findBuyerByUser(User user);
}
