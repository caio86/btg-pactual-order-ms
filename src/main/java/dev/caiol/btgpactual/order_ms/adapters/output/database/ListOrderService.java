package dev.caiol.btgpactual.order_ms.adapters.output.database;

import org.springframework.stereotype.Service;

import dev.caiol.btgpactual.order_ms.adapters.output.database.entity.OrderEntity;
import dev.caiol.btgpactual.order_ms.adapters.output.database.repository.OrderRepository;
import dev.caiol.btgpactual.order_ms.application.domain.model.OrderDomain;
import dev.caiol.btgpactual.order_ms.application.domain.model.Page;
import dev.caiol.btgpactual.order_ms.application.domain.model.PageRequest;
import dev.caiol.btgpactual.order_ms.application.ports.out.IListOrders;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListOrderService implements IListOrders {

  private final OrderRepository repository;

  @Override
  public Page<OrderDomain> execute(Long custmerId, PageRequest pageRequest) {
    var fullPageRequest = org.springframework.data.domain.PageRequest.of(
        pageRequest.pageNumber(),
        pageRequest.pageSize());

    var orders = repository.findAllByCustomerId(custmerId, fullPageRequest);

    return new Page<>(
        orders.getContent().stream().map(OrderEntity::toDomain).toList(),
        orders.getNumber(),
        orders.getSize(),
        orders.getTotalElements(),
        orders.getTotalPages());

  }

}
