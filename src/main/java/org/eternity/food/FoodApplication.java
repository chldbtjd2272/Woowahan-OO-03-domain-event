package org.eternity.food;

import lombok.RequiredArgsConstructor;
import org.eternity.food.generic.money.domain.Money;
import org.eternity.food.order.service.Cart;
import org.eternity.food.order.service.Cart.CartLineItem;
import org.eternity.food.order.service.Cart.CartOption;
import org.eternity.food.order.service.Cart.CartOptionGroup;
import org.eternity.food.order.service.port.in.DeliverOrder;
import org.eternity.food.order.service.port.in.PayOrder;
import org.eternity.food.order.service.port.in.PlaceOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class FoodApplication implements CommandLineRunner {
    private static Logger LOG = LoggerFactory.getLogger(FoodApplication.class);

    private final PlaceOrder placeOrder;
    private final DeliverOrder deliverOrder;
    private final PayOrder payOrder;


    @Override
    public void run(String... args) {
        Cart cart = new Cart(1L, 1L,
                new CartLineItem(1L, "삼겹살 1인세트", 2,
                        new CartOptionGroup("기본",
                                new CartOption("소(250g)", Money.wons(12000)))));

        placeOrder.placeOrder(cart);

        payOrder.payOrder(1L);

        deliverOrder.deliverOrder(1L);
    }

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(FoodApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }
}
