package dev.caiol.btgpactual.order_ms.adapters.output.database.entity;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

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
}
