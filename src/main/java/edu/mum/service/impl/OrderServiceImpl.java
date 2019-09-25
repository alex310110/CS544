package edu.mum.service.impl;

import edu.mum.dao.CartItemDao;
import edu.mum.dao.OrderDao;
import edu.mum.dao.OrderItemDao;
import edu.mum.domain.*;
import edu.mum.domain.view.OrderInfo;
import edu.mum.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private CartItemDao cartItemDao;

    @Override
    public Order getOrderById(Long id) {
        return orderDao.findOne(id);
    }

    @Override
    public Order saveOrder(Buyer buyer, Order order) {
        List<CartItem> cartItems = (List) cartItemDao.getCartItemByBuyerId(buyer.getId());
        BigDecimal totalAmount = new BigDecimal(0.00);
        for (CartItem ci : cartItems) {
            OrderItem oi = new OrderItem();
            oi.setProduct(ci.getProduct());
            oi.setQuantity(ci.getQuantity());
            order.addOrderItem(oi);
            oi.setOrder(order);
            totalAmount = totalAmount.add(ci.getProduct().getPrice().multiply(new BigDecimal(ci.getQuantity())));
            cartItemDao.delete(ci.getId());
        }
        if (order.getUsingPoints() == true) {
            totalAmount = totalAmount.subtract(new BigDecimal(buyer.getPoints()));
            if (totalAmount.compareTo(BigDecimal.ZERO) > 0) {
                buyer.setPoints(0);
            } else {
                buyer.setPoints(totalAmount.abs().intValue());
            }
        }
        order.setTotalAmount(totalAmount);
        String info = order.getPaymentInfo();
        String last4Digits;
        if (info.length() <= 4) {
            last4Digits = info;
        } else {
            last4Digits = info.substring(info.length() - 4);
        }
        info = "Paid by the card number XXXX XXXX XXXX " + last4Digits;
        order.setPaymentInfo(info);
        order.setBuyer(buyer);
        order.setOrderedDate(LocalDateTime.now());
        buyer.addOrder(order);
        return orderDao.save(order);
    }

    public Order updateOrder(Order order) {
        return orderDao.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderDao.delete(orderDao.findOne(id).getId());
    }

    @Override
    public void completeOrder(Order order) {
        order.setStatus(OrderStatus.COMPLETED);
        Integer points = order.getTotalAmount().divide(new BigDecimal(100)).intValue();
        order.getBuyer().setPoints(order.getBuyer().getPoints() + points);
        orderDao.save(order);
    }

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemDao.save(orderItem);
    }

    @Override
    public void cancelOrder(Order order) {
        order.setStatus(OrderStatus.CANCELED);
        order.setEndDate(LocalDateTime.now());
        order.setTotalAmount(new BigDecimal(0));
        order.setPaymentInfo("");
        List<OrderItem> orderItems = order.getOrderItems();
        for (OrderItem i : orderItems) {
            i.setOrderStatus(OrderItemStatus.CANCELED);
        }
        orderDao.save(order);
    }

    @Override
    public File downloadReceipt(OrderInfo orderInfo) throws Exception {
        Map<String, OrderInfo> data = new HashMap<String, OrderInfo>();
        data.put("order", orderInfo);
//        return pdfGenerator.createPdf("buyer/PDF", data);
        return null;

    }

    @Override
    public OrderItem getOrderItemById(Long itemId) {
        return orderItemDao.findOne(itemId);
    }

    @Override
    public List<OrderItem> getOrderItemsBySeller(Long sellerId) {
        return orderItemDao.getOrderItemsBySeller(sellerId);
    }

    @Override
    public List<Order> getAll() {
        return (List<Order>) orderDao.findAll();
    }

    @Override
    public List<OrderItem> getDeliveredOrderItemsByOrder(Long orderId) {
        return orderItemDao.getDeliveredOrderItemsByOrder(orderId);
    }


}
