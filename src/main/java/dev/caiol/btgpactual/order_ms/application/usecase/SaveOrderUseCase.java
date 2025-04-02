package dev.caiol.btgpactual.order_ms.application.usecase;

import dev.caiol.btgpactual.order_ms.application.domain.model.OrderDomain;
import dev.caiol.btgpactual.order_ms.application.ports.in.ISaveOrderUseCase;
import dev.caiol.btgpactual.order_ms.application.ports.out.ISaveOrder;
import dev.caiol.btgpactual.order_ms.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class SaveOrderUseCase implements ISaveOrderUseCase {

  private final ISaveOrder saveOrder;

  @Override
  public void execute(OrderDomain domain) {
    domain.save(saveOrder);
  }
}
