package dev.caiol.btgpactual.order_ms.adapters.input.queue;

import java.math.BigDecimal;

public record OrderItemEventDTO(
    String produto,
    Integer quantidade,
    BigDecimal preco) {
}
