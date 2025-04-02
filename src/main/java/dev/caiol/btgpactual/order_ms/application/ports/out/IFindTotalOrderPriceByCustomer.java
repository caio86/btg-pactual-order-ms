package dev.caiol.btgpactual.order_ms.application.ports.out;

import java.math.BigDecimal;

public interface IFindTotalOrderPriceByCustomer {
  BigDecimal execute(Long customerId);
}
