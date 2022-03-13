package org.eternity.food.shop.service.port.out;

import org.eternity.food.shop.domain.Menu;
import org.eternity.food.shop.domain.Shop;

import java.util.List;

public interface LoadShopPort {
    Shop findShopById(Long id);

    List<Menu> findMenusByShopId(Long shopId);
}
