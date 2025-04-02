package dev.caiol.btgpactual.order_ms.application.domain.model;

import java.util.List;

public record Page<T>(
    List<T> content,
    Integer number,
    Integer size,
    Long totalElements,
    Integer totalPages) {
}
