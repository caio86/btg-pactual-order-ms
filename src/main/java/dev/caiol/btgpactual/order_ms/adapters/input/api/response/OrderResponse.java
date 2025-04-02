package dev.caiol.btgpactual.order_ms.adapters.input.api.response;

import java.math.BigDecimal;

import dev.caiol.btgpactual.order_ms.application.domain.model.OrderDomain;

public record OrderResponse(
    Long orderId,
    Long customerId,
    BigDecimal total) {

  public static OrderResponse fromDomain(OrderDomain domain) {
    return new OrderResponse(
        domain.getOrderId(),
        domain.getCustomerId(),
        domain.getTotal());
  }

}
