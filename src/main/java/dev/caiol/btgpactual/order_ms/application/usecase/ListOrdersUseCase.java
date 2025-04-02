package dev.caiol.btgpactual.order_ms.application.usecase;

import dev.caiol.btgpactual.order_ms.application.domain.model.OrderDomain;
import dev.caiol.btgpactual.order_ms.application.domain.model.Page;
import dev.caiol.btgpactual.order_ms.application.domain.model.PageRequest;
import dev.caiol.btgpactual.order_ms.application.ports.in.IListOrdersUseCase;
import dev.caiol.btgpactual.order_ms.application.ports.out.IListOrders;
import dev.caiol.btgpactual.order_ms.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class ListOrdersUseCase implements IListOrdersUseCase {

  private final IListOrders listOrders;

  @Override
  public Page<OrderDomain> execute(Long customerId, PageRequest pageRequest) {
    return listOrders.execute(customerId, pageRequest);
  }

}
