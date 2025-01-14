package org.eternity.food.shop.adapter.out;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.eternity.food.generic.money.domain.Money;
import org.eternity.food.generic.money.domain.Ratio;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "SHOPS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShopJpaEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "SHOP_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "OPEN")
    private boolean open;

    @Column(name = "MIN_ORDER_AMOUNT")
    private Money minOrderAmount;

    @Column(name = "COMMISSION_RATE")
    private Ratio commissionRate;

    @Builder
    public ShopJpaEntity(String name, boolean open, Money minOrderAmount, Ratio commissionRate) {
        this.id = id;
        this.name = name;
        this.open = open;
        this.minOrderAmount = minOrderAmount;
        this.commissionRate = commissionRate;
    }
}
