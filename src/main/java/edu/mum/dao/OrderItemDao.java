package edu.mum.dao;

import edu.mum.domain.OrderItem;

import java.util.List;

public interface OrderItemDao extends GenericDao<OrderItem>{
    List<OrderItem> getOrderItemsBySeller(Long sellerId);
    List<String> getApprovedReviews(Long itemId);
    List<OrderItem> getOrderItemWithNotNullReviews();
    List<OrderItem> getDeliveredOrderItemsByOrder(Long orderId);
}
