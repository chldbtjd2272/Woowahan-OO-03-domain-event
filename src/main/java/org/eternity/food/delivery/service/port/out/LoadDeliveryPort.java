package org.eternity.food.delivery.service.port.out;

import org.eternity.food.delivery.domain.Delivery;

public interface LoadDeliveryPort {
    Delivery loadDeliveryById(Long id);
}
