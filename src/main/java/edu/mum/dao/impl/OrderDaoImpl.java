package edu.mum.dao.impl;

import edu.mum.domain.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order> implements edu.mum.dao.OrderDao {
    public OrderDaoImpl() {
        super.setDaoType(Order.class );
    }
}
