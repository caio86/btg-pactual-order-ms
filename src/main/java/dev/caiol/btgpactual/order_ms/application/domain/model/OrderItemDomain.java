package dev.caiol.btgpactual.order_ms.application.domain.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemDomain {

  private String product;
  private Integer quantity;
  private BigDecimal price;
}
