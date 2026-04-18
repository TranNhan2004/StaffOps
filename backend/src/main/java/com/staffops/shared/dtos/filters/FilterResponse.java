package com.staffops.shared.dtos.filters;

import com.staffops.shared.dtos.pagination.PaginatedListResponse;
import com.staffops.shared.models.filters.FilterResult;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilterResponse<T> extends PaginatedListResponse<T> {
    public static <T> FilterResponse<T> fromModel(FilterResult<T> result) {
        PaginatedListResponse<T> response = PaginatedListResponse.fromModel(result);
        return (FilterResponse<T>) response;
    }
}
