package org.eternity.food.billing.service.port.in;

import org.eternity.food.generic.money.domain.Money;

public interface BillShop {
    void bill(Long shopId, Money price);
}
