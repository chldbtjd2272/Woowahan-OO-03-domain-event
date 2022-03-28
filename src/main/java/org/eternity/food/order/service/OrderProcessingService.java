package org.eternity.food.order.service;

import lombok.RequiredArgsConstructor;
import org.eternity.food.order.domain.Order;
import org.eternity.food.order.service.port.out.LoadOrderPort;
import org.eternity.food.order.service.port.out.UpdateOrderStatusPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProcessingService {
    private final LoadOrderPort loadOrderPort;
    private final UpdateOrderStatusPort updateOrderStatusPort;

    public Order payOrder(Long orderId) {
        Order order = loadOrderPort.findById(orderId);
        order.payed();
        updateOrderStatusPort.updateOrder(order);       // Domain Event 발행을 위해
        return order;
    }

    public Order deliverOrder(Long orderId) {
        Order order = loadOrderPort.findById(orderId);
        order.delivered();
        updateOrderStatusPort.updateOrder(order);       // Domain Event 발행을 위해
        return order;
    }
}
