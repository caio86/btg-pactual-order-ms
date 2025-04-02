package dev.caiol.btgpactual.order_ms.application.usecase;

import java.math.BigDecimal;

import dev.caiol.btgpactual.order_ms.application.ports.in.IFindTotalOrderPriceByCustomerUseCase;
import dev.caiol.btgpactual.order_ms.application.ports.out.IFindTotalOrderPriceByCustomer;
import dev.caiol.btgpactual.order_ms.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class FindTotalOrderPriceByCustomerUseCase implements IFindTotalOrderPriceByCustomerUseCase {

  private final IFindTotalOrderPriceByCustomer findTotalOrderPriceByCustomer;

  @Override
  public BigDecimal execute(Long customerId) {
    return findTotalOrderPriceByCustomer.execute(customerId);
  }

}
