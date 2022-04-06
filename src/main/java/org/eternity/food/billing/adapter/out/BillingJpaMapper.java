package org.eternity.food.billing.adapter.out;

import org.eternity.food.billing.domain.Billing;
import org.springframework.stereotype.Component;

@Component
public class BillingJpaMapper {

    public BillingJpaEntity mapFrom(Billing billing) {
        return new BillingJpaEntity(billing.getId(), billing.getShopId(), billing.getCommission());
    }

    public Billing mapFrom(BillingJpaEntity billing) {
        return new Billing(billing.getId(), billing.getShopId(), billing.getCommission());
    }
}
