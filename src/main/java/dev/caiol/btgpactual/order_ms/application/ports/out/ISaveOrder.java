package dev.caiol.btgpactual.order_ms.application.ports.out;

import dev.caiol.btgpactual.order_ms.application.domain.model.OrderDomain;

public interface ISaveOrder {
  void execute(OrderDomain domain);
}
