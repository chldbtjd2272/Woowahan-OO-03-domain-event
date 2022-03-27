package org.eternity.food.order.service;

import lombok.RequiredArgsConstructor;
import org.eternity.food.order.domain.Order;
import org.eternity.food.order.service.port.in.DeliverOrder;
import org.eternity.food.order.service.port.in.PayOrder;
import org.eternity.food.order.service.port.out.LoadOrderPort;
import org.eternity.food.order.service.port.out.UpdateOrderStatusPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderProcessingService implements PayOrder, DeliverOrder {
    private final LoadOrderPort loadOrderPort;
    private final UpdateOrderStatusPort updateOrderStatusPort;

    @Transactional
    public void payOrder(Long orderId) {
        Order order = loadOrderPort.findById(orderId);
        order.payed();
        updateOrderStatusPort.updateOrder(order);       // Domain Event 발행을 위해
    }

    @Transactional
    public void deliverOrder(Long orderId) {
        Order order = loadOrderPort.findById(orderId);
        order.delivered();
        updateOrderStatusPort.updateOrder(order);       // Domain Event 발행을 위해
    }
}
