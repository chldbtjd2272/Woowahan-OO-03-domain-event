package org.eternity.food.order.service.port.out;

import org.eternity.food.order.domain.Order;

public interface UpdateOrderStatusPort {
    Order updateOrder(Order order);
}
