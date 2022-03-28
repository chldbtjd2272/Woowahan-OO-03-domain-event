package org.eternity.food.order.service.port.out;

import org.eternity.food.order.domain.OrderDeliveredEvent;
import org.eternity.food.order.domain.OrderPayedEvent;

public interface OrderEventSenderPort {

    void send(OrderDeliveredEvent order);

    void send(OrderPayedEvent order);
}
