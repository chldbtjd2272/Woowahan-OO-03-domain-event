package org.eternity.food.order.adapter.out;

import lombok.RequiredArgsConstructor;
import org.eternity.food.order.domain.Order;
import org.eternity.food.order.service.port.out.CreateOrderPort;
import org.eternity.food.order.service.port.out.LoadOrderPort;
import org.eternity.food.order.service.port.out.UpdateOrderStatusPort;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements CreateOrderPort, LoadOrderPort, UpdateOrderStatusPort {
    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Order updateOrder(Order order) {
        if (order.getId() != null) {
            orderRepository.save(order);
        }
        return order;
    }
}
