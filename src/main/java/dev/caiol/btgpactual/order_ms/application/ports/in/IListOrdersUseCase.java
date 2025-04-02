package dev.caiol.btgpactual.order_ms.application.ports.in;

import dev.caiol.btgpactual.order_ms.application.domain.model.OrderDomain;
import dev.caiol.btgpactual.order_ms.application.domain.model.Page;
import dev.caiol.btgpactual.order_ms.application.domain.model.PageRequest;

public interface IListOrdersUseCase {
  Page<OrderDomain> execute(Long customerId, PageRequest pageRequest);
}
