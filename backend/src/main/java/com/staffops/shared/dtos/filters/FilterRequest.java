package com.staffops.shared.dtos.filters;

import com.staffops.shared.dtos.pagination.PaginatedListRequest;
import com.staffops.shared.models.filters.FilterQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FilterRequest extends PaginatedListRequest {
    private List<FilterCriteriaRequest> filterCriteriaRequestList;

    public static FilterQuery toModel(FilterRequest request) {
        FilterQuery model = new FilterQuery();
        model.setPage(request.getPage());
        model.setSize(request.getSize());
        model.setFilterCriteriaList(
            request
                .getFilterCriteriaRequestList()
                .stream()
                .map(FilterCriteriaRequest::toModel)
                .toList()
        );
        return model;
    }
}
