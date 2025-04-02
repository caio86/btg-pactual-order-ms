package dev.caiol.btgpactual.order_ms.adapters.output.database.entity;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import dev.caiol.btgpactual.order_ms.application.domain.model.OrderDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tb_orders")
public class OrderEntity {

  @MongoId
  private long orderId;

  @Indexed(name = "customer_id_index")
  private long customerId;

  @Field(targetType = FieldType.DECIMAL128)
  private BigDecimal total;

  private List<OrderItem> items;

  public static OrderEntity fromDomain(OrderDomain domain) {
    return new OrderEntity(
        domain.getOrderId(),
        domain.getCustomerId(),
        domain.getTotal(),
        domain.getItems().stream().map(OrderItem::fromItemDomain).toList());
  }

  public static OrderDomain toDomain(OrderEntity entity) {
    return new OrderDomain(
        entity.getOrderId(),
        entity.getCustomerId(),
        entity.getTotal(),
        entity.getItems().stream().map(OrderItem::toItemDomain).toList());
  }
}
