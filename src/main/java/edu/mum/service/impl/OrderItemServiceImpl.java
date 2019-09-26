package edu.mum.service.impl;

import edu.mum.dao.OrderItemDao;
import edu.mum.domain.OrderItem;
import edu.mum.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemDao orderItemDao;

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemDao.save(orderItem);
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
        return orderItemDao.update(orderItem);
    }

    @Override
    public List<OrderItem> getOrderItems() {
        return (List<OrderItem>) orderItemDao.findAll();
    }

    @Override
    public List<OrderItem> getOrderItemsWithNotNullReviews() {
        return orderItemDao.getOrderItemWithNotNullReviews();
    }

    @Override
    public OrderItem getOrderItemById(Long id) {
        return orderItemDao.findOne(id);
    }

    @Override
    public List<String> getApprovedReviews(Long itemId) {
        return orderItemDao.getApprovedReviews(itemId);
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemDao.delete(orderItemDao.findOne(id).getId());

    }

}
