package org.eternity.food.delivery.adapter.in;

import lombok.RequiredArgsConstructor;
import org.eternity.food.delivery.service.port.in.StartDelivery;
import org.eternity.food.order.domain.OrderPayedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartDeliveryWithOrderPayedEventHandler {
    private StartDelivery startDelivery;

    @Async
    @EventListener
    public void handle(OrderPayedEvent event) {
        startDelivery.delivery(event.getOrderId());
    }
}
