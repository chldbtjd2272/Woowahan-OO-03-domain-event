package org.eternity.food.delivery.adapter.in;

import lombok.RequiredArgsConstructor;
import org.eternity.food.delivery.service.port.in.CompleteDelivery;
import org.eternity.food.order.domain.OrderDeliveredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompleteDeliveryWithOrderDeliveredEventHandler {
    private final CompleteDelivery completeDelivery;


    @Async
    @EventListener
    public void handle(OrderDeliveredEvent event) {
        completeDelivery.complete(event.getOrderId());
    }
}
