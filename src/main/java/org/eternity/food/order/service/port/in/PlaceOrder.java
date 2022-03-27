package org.eternity.food.order.service.port.in;

import org.eternity.food.order.service.Cart;

public interface PlaceOrder {
    void placeOrder(Cart cart);
}
