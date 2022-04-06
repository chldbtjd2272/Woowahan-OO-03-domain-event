package org.eternity.food.delivery.adapter.out;

import org.eternity.food.delivery.domain.Delivery;
import org.springframework.stereotype.Component;

@Component
public class DeliveryJpaMapper {

    public DeliveryJpaEntity mapFrom(Delivery delivery) {
        return new DeliveryJpaEntity(delivery.getId(), delivery.getOrderId(), delivery.getDeliveryStatus());
    }

    public Delivery mapFrom(DeliveryJpaEntity delivery) {
        return new Delivery(delivery.getId(), delivery.getOrderId(), delivery.getDeliveryStatus());
    }
}
