package dev.caiol.btgpactual.order_ms.adapters.output.database.entity;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import dev.caiol.btgpactual.order_ms.application.domain.model.OrderItemDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

  private String product;

  private Integer quantity;

  @Field(targetType = FieldType.DECIMAL128)
  private BigDecimal price;

  public static OrderItem fromItemDomain(OrderItemDomain domain) {
    return new OrderItem(
        domain.getProduct(),
        domain.getQuantity(),
        domain.getPrice());
  }

  public static OrderItemDomain toItemDomain(OrderItem orderItem) {
    return OrderItemDomain.builder()
        .product(orderItem.getProduct())
        .quantity(orderItem.getQuantity())
        .price(orderItem.getPrice())
        .build();
  }
}
