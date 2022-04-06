package org.eternity.food.delivery.service;

import lombok.RequiredArgsConstructor;
import org.eternity.food.delivery.domain.Delivery;
import org.eternity.food.delivery.service.port.in.StartDelivery;
import org.eternity.food.delivery.service.port.out.CreateDeliveryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StartDeliveryService implements StartDelivery {

    private final CreateDeliveryPort createDeliveryPort;

    @Override
    @Transactional
    public void delivery(Long orderId) {
        Delivery delivery = Delivery.started(orderId);
        createDeliveryPort.createDelivery(delivery);
    }
}
