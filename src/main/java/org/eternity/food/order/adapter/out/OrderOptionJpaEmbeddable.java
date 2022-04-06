package org.eternity.food.order.adapter.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.eternity.food.generic.money.domain.Money;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
public class OrderOptionJpaEmbeddable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Money price;

    @Builder
    public OrderOptionJpaEmbeddable(String name, Money price) {
        this.name = name;
        this.price = price;
    }

}
