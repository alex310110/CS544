package edu.mum.service.impl;

import edu.mum.dao.BuyerDao;
import edu.mum.dao.OrderItemDao;
import edu.mum.domain.*;
import edu.mum.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private BuyerDao buyerDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Override
    public Buyer saveBuyer(Buyer buyer) {
        buyer.getUser().setRole(Role.BUYER);
        return buyerDao.save(buyer);
    }

    @Override
    public Buyer updateBuyer(Buyer buyer) {
        Buyer persistedBuyer = getBuyerById(buyer.getId());
        persistedBuyer.setUser(buyer.getUser());
        System.out.println(persistedBuyer);
        return buyerDao.save(persistedBuyer);
    }

    @Override
    public Buyer getBuyerById(Long id) {
        return buyerDao.findOne(id);
    }

    @Override
    public Buyer getBuyerByUser(User user) {
        return buyerDao.findBuyerByUser(user);
    }


    @Override
    public void followSeller(Buyer buyer, Seller seller) {
        buyer.followSeller(seller);
        seller.addBuyer(buyer);
        buyerDao.save(buyer);
    }

    @Override
    public void unfollowSeller(Buyer buyer, Seller seller) {
        buyer.unfollowSeller(seller);
        seller.removeBuyer(buyer);
        buyerDao.save(buyer);
    }

    @Override
    public List<Order> getOrdersByBuyerId(Long buyerId) {
        return buyerDao.findOne(buyerId).getOrders();
    }

    @Override
    public void addReview(OrderItem item, String review) {
        item.setReview(review);
        item.setReviewDate(LocalDateTime.now());
        orderItemDao.save(item);
    }

    @Override
    public List<Seller> getFollowings(Long buyerId) {
        return buyerDao.findOne(buyerId).getSellers();
    }

}
