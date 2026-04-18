package com.staffops.shared.dtos.pagination;

import com.staffops.shared.models.pagination.PaginatedListResult;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PaginatedListResponse<T> {
    private List<T> items;
    private int page;
    private int size;
    private int totalPages;
    private int totalItems;
    private boolean hasNextPage;
    private boolean hasPreviousPage;

    public static <T> PaginatedListResponse<T> fromModel(PaginatedListResult<T> result) {
        PaginatedListResponse<T> response = new PaginatedListResponse<>();
        response.setItems(result.getItems());
        response.setPage(result.getPage());
        response.setSize(result.getSize());
        response.setTotalPages(result.getTotalPages());
        response.setTotalItems(result.getTotalItems());
        response.setHasNextPage(result.isHasNextPage());
        response.setHasPreviousPage(result.isHasPreviousPage());
        return response;
    }
}
