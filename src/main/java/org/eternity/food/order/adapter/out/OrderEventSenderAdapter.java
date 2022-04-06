package org.eternity.food.order.adapter.out;

import lombok.RequiredArgsConstructor;
import org.eternity.food.order.domain.OrderDeliveredEvent;
import org.eternity.food.order.domain.OrderPayedEvent;
import org.eternity.food.order.service.port.out.OrderEventSenderPort;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventSenderAdapter implements OrderEventSenderPort {
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void send(OrderDeliveredEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void send(OrderPayedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
