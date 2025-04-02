package dev.caiol.btgpactual.order_ms.application.ports.in;

import dev.caiol.btgpactual.order_ms.application.domain.model.OrderDomain;

public interface ISaveOrderUseCase {
  void execute(OrderDomain domain);
}
