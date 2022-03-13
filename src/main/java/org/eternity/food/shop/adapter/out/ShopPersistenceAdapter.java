package org.eternity.food.shop.adapter.out;

import org.eternity.food.shop.domain.Menu;
import org.eternity.food.shop.domain.Shop;
import org.eternity.food.shop.service.port.out.LoadShopPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ShopPersistenceAdapter implements LoadShopPort {
    private final ShopMapper shopMapper;
    private final ShopJpaRepository shopJpaRepository;
    private final MenuJpaRepository menuJpaRepository;

    public ShopPersistenceAdapter(ShopMapper shopMapper, ShopJpaRepository shopJpaRepository,
                                  MenuJpaRepository menuJpaRepository) {
        this.shopMapper = shopMapper;
        this.shopJpaRepository = shopJpaRepository;
        this.menuJpaRepository = menuJpaRepository;
    }

    @Override
    public Shop findShopById(Long id) {
        return shopMapper.mapToShop(shopJpaRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public List<Menu> findMenusByShopId(Long shopId) {
        return menuJpaRepository.findByShopId(shopId).stream()
                .map(shopMapper::mapToMenu)
                .collect(Collectors.toList());
    }
}
