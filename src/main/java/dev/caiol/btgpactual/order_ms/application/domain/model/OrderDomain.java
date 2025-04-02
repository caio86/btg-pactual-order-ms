package dev.caiol.btgpactual.order_ms.application.domain.model;

import java.math.BigDecimal;
import java.util.List;

import dev.caiol.btgpactual.order_ms.application.ports.out.ISaveOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDomain {

  private long orderId;
  private long customerId;
  private BigDecimal total;
  private List<OrderItem> items;

  public void save(ISaveOrder saveOrder) {
    saveOrder.execute(this);
  }
}
