package org.eternity.food.shop.service.port.in;

import org.eternity.food.shop.service.MenuBoard;

public interface GetMenuQuery {
    MenuBoard getMenuBoard(Long shopId);
}
