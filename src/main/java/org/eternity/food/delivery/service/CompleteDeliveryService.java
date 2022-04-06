package org.eternity.food.delivery.service;

import lombok.RequiredArgsConstructor;
import org.eternity.food.delivery.domain.Delivery;
import org.eternity.food.delivery.service.port.in.CompleteDelivery;
import org.eternity.food.delivery.service.port.out.LoadDeliveryPort;
import org.eternity.food.delivery.service.port.out.UpdateDeliveryStatusPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompleteDeliveryService implements CompleteDelivery {
    private final LoadDeliveryPort loadDeliveryPort;
    private final UpdateDeliveryStatusPort updateDeliveryStatusPort;

    @Override
    public void complete(Long id) {
        Delivery delivery = loadDeliveryPort.loadDeliveryById(id);
        delivery.complete();
        updateDeliveryStatusPort.updateDeliveryStatus(delivery);
    }
}
