package dev.caiol.btgpactual.order_ms.adapters.output.database;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import dev.caiol.btgpactual.order_ms.adapters.output.database.entity.OrderEntity;
import dev.caiol.btgpactual.order_ms.adapters.output.database.repository.OrderRepository;
import dev.caiol.btgpactual.order_ms.application.domain.model.OrderDomain;
import dev.caiol.btgpactual.order_ms.application.ports.out.ISaveOrder;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaveOrderService implements ISaveOrder {

  private final OrderRepository repository;

  @Override
  public void execute(OrderDomain domain) {
    var entity = OrderEntity.fromDomain(domain);

    entity.setTotal(getTotal(entity));

    repository.save(entity);
  }

  private BigDecimal getTotal(OrderEntity entity) {
    return entity.getItems().stream()
        .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
        .reduce(BigDecimal::add)
        .orElse(BigDecimal.ZERO);
  }

}
