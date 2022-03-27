package org.eternity.food.shop.service.port.in;

import org.eternity.food.shop.domain.Menu;
import org.eternity.food.shop.domain.Shop;

import java.util.List;

public interface GetOrderShopQuery {
    Shop findShopById(Long shopId);

    List<Menu> findMenusByMenuIds(List<Long> menuIds);
}
