package edu.mum.service.impl;

import edu.mum.dao.SellerDao;
import edu.mum.domain.Buyer;
import edu.mum.domain.Product;
import edu.mum.domain.Seller;
import edu.mum.domain.User;
import edu.mum.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    SellerDao sellerDao;

    @Override
    public Seller getSellerById(Long id) {
        return sellerDao.findOne(id);
    }

    @Override
    public Seller save(Seller seller) {
        return sellerDao.save(seller);
    }

    @Override
    public Seller getSellerByUser(User user) {
        return sellerDao.findSellerByUser(user);
    }

    @Override
    public List<Buyer> getFollowers(Long sellerId) {
        return sellerDao.findOne(sellerId).getBuyers();
    }

    public Seller updateSeller(Seller seller) {
        Seller selectSeller = sellerDao.findOne(seller.getId());
        selectSeller.setName(seller.getName());
        selectSeller.setDescription(seller.getDescription());
        selectSeller.setPicture(seller.getPicture());
        return sellerDao.save(selectSeller);
    }

    @Override
    public List<Seller> getAllSellers() {
        return (List) sellerDao.findAll();
    }
}
