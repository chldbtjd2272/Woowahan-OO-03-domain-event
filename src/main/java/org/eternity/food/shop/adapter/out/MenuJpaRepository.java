package org.eternity.food.shop.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuJpaRepository extends JpaRepository<MenuJpaEntity, Long> {
    List<MenuJpaEntity> findByShopId(Long shopId);
}
