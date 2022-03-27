package org.eternity.food.shop.service;

import lombok.RequiredArgsConstructor;
import org.eternity.food.shop.domain.Menu;
import org.eternity.food.shop.domain.Shop;
import org.eternity.food.shop.service.port.in.GetOrderShopQuery;
import org.eternity.food.shop.service.port.out.LoadShopPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderShopQueryService implements GetOrderShopQuery {
    private final LoadShopPort loadShopPort;

    @Override
    public Shop findShopById(Long shopId) {
        return loadShopPort.findShopById(shopId);
    }

    @Override
    public List<Menu> findMenusByMenuIds(List<Long> menuIds) {
        return loadShopPort.findMenusByMenuIds(menuIds);
    }
}
