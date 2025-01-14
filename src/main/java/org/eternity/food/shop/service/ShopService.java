package org.eternity.food.shop.service;

import org.eternity.food.shop.domain.Menu;
import org.eternity.food.shop.domain.Shop;
import org.eternity.food.shop.service.port.in.GetMenuQuery;
import org.eternity.food.shop.service.port.out.LoadShopPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShopService implements GetMenuQuery {
    private LoadShopPort loadShopPort;

    public ShopService(LoadShopPort loadShopPort) {
        this.loadShopPort = loadShopPort;
    }

    @Transactional(readOnly = true)
    public MenuBoard getMenuBoard(Long shopId) {
        Shop shop = loadShopPort.findShopById(shopId);
        List<Menu> menus = loadShopPort.findMenusByShopId(shopId);
        return new MenuBoard(shop, menus);
    }
}
