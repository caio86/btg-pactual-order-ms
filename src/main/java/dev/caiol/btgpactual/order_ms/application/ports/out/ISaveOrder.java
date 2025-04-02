package dev.caiol.btgpactual.order_ms.application.ports.out;

import dev.caiol.btgpactual.order_ms.application.domain.OrderDomain;

public interface ISaveOrder {
  void execute(OrderDomain domain);
}
