package dev.caiol.btgpactual.order_ms.adapters.input.api.response;

import java.util.List;

public record ApiListResponse<T>(
    List<T> data,
    PagintionResponse pagination) {
}
