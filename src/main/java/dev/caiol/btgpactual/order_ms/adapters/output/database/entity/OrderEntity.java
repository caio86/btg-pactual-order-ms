package dev.caiol.btgpactual.order_ms.adapters.output.database.entity;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

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
}
