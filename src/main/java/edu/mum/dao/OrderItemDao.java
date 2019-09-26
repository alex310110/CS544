package edu.mum.dao;

import edu.mum.domain.OrderItem;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface OrderItemDao extends GenericDao<OrderItem>{
    List<OrderItem> getOrderItemsBySeller(Long sellerId);
    List<String> getApprovedReviews(Long itemId);
    List<OrderItem> getOrderItemWithNotNullReviews();
    List<OrderItem> getDeliveredOrderItemsByOrder(Long orderId);
}
