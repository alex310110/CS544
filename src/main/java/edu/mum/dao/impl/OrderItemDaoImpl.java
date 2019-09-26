package edu.mum.dao.impl;

import edu.mum.domain.OrderItem;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
//@Transactional
public class OrderItemDaoImpl extends GenericDaoImpl<OrderItem> implements edu.mum.dao.OrderItemDao {
    public OrderItemDaoImpl() {
        super.setDaoType(OrderItem.class);
    }

    @Override
    public List<OrderItem> getOrderItemsBySeller(Long sellerId) {

        Query query = entityManager.createQuery("select i from OrderItem i " +
                "inner join Product p on i.product.id = p.id " +
                "inner join Seller s on p.seller.id = s.id " +
                "inner join Order o on i.order.id = o.id " +
                "where s.id = :sellerId");
        return query.setParameter("sellerId", sellerId).getResultList();
    }

    @Override
    public List<String> getApprovedReviews(Long itemId) {

        Query query = entityManager.createQuery("select i.review from OrderItem i where i.review_status = 'APPROVED' and i.id = :itemId");
        return (List<String>) query.setParameter("itemId", itemId).getResultList();

    }

    @Override
    public List<OrderItem> getOrderItemWithNotNullReviews() {
        Query query = entityManager.createQuery("select i from OrderItem i where i.review is not null");
        return (List<OrderItem>) query.getResultList();
    }

    @Override
    public List<OrderItem> getDeliveredOrderItemsByOrder(Long orderId) {
        Query query = entityManager.createQuery("select i from OrderItem i where i.order_status = 'DELIVERED' and i.order_id = :orderId");
        return (List<OrderItem>) query.setParameter("orderId", orderId).getResultList();
    }
}
