package dev.caiol.btgpactual.order_ms.application.ports.in;

import java.math.BigDecimal;

public interface IFindTotalOrderPriceByCustomerUseCase {
  BigDecimal execute(Long customerId);
}
