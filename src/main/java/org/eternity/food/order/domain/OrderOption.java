package org.eternity.food.order.domain;

import lombok.Builder;
import lombok.Getter;
import org.eternity.food.generic.money.domain.Money;
import org.eternity.food.shop.domain.Option;

@Getter
public class OrderOption {

    private String name;
    private Money price;

    @Builder
    public OrderOption(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    public Option convertToOption() {
        return new Option(name, price);
    }
}
