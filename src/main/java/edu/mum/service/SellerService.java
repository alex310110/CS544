package edu.mum.service;

import edu.mum.domain.Buyer;
import edu.mum.domain.Seller;
import edu.mum.domain.User;

import java.util.List;
import java.util.Set;

public interface SellerService {
    Seller getSellerById(Long id);
    Seller save(Seller seller);
    Seller getSellerByUser(User user);
    List<Buyer> getFollowers(Long sellerId);
    Seller updateSeller(Seller seller);
    List<Seller> getAllSellers();
}
