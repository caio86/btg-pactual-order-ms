package dev.caiol.btgpactual.order_ms.adapters.input.queue;

import java.util.List;

public record OrderCreatedEventDTO(
    Long codigoPedido,
    Long codigoCliente,
    List<OrderItemEventDTO> itens) {
}
