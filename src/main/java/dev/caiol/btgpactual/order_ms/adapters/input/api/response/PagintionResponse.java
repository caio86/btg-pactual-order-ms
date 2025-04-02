package dev.caiol.btgpactual.order_ms.adapters.input.api.response;

import dev.caiol.btgpactual.order_ms.application.domain.model.Page;

public record PagintionResponse(
    Integer page,
    Integer pageSize,
    Long totalElements,
    Integer totalPages) {

  public static PagintionResponse fromPage(Page<?> page) {
    return new PagintionResponse(
        page.number(),
        page.size(),
        page.totalElements(),
        page.totalPages());
  }
}
