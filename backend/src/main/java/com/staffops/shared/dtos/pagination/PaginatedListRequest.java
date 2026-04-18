package com.staffops.shared.dtos.pagination;

import com.staffops.shared.models.pagination.PaginatedListQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaginatedListRequest {
    private int page;
    private int size;

    public static PaginatedListQuery toModel(PaginatedListRequest request) {
        PaginatedListQuery model = new PaginatedListQuery();
        model.setPage(request.getPage());
        model.setSize(request.getSize());
        return model;
    }
}
