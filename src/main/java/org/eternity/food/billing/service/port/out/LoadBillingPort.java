package org.eternity.food.billing.service.port.out;

import org.eternity.food.billing.domain.Billing;

public interface LoadBillingPort {
    Billing loadByShopId(Long shopId);
}
