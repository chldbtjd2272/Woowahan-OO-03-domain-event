package org.eternity.food.order.domain;

import lombok.Builder;
import lombok.Getter;
import org.eternity.food.generic.money.domain.Money;
import org.eternity.food.shop.domain.OptionGroup;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
public class OrderLineItem {
    private Long id;

    private Long menuId;

    private String name;

    private int count;

    private final List<OrderOptionGroup> groups = new ArrayList<>();

    public OrderLineItem(Long menuId, String name, int count, List<OrderOptionGroup> groups) {
        this(null, menuId, name, count, groups);
    }

    @Builder
    public OrderLineItem(Long id, Long menuId, String name, int count, List<OrderOptionGroup> groups) {
        this.id = id;
        this.menuId = menuId;
        this.name = name;
        this.count = count;
        this.groups.addAll(groups);
    }

    public Money calculatePrice() {
        return Money.sum(groups, OrderOptionGroup::calculatePrice).times(count);
    }

    private List<OptionGroup> convertToOptionGroups() {
        return groups.stream().map(OrderOptionGroup::convertToOptionGroup).collect(toList());
    }
}
