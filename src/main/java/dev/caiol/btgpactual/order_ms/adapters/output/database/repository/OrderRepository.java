package dev.caiol.btgpactual.order_ms.adapters.output.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.caiol.btgpactual.order_ms.adapters.output.database.entity.OrderEntity;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {
}
