package com.staffops.shared.models.pagination;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PaginatedListResult<T> {
    private List<T> items;
    private int page;
    private int size;
    private int totalPages;
    private int totalItems;
    private boolean hasNextPage;
    private boolean hasPreviousPage;
}
