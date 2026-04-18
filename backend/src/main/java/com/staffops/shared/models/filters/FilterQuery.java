package com.staffops.shared.models.filters;

import com.staffops.shared.models.pagination.PaginatedListQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FilterQuery extends PaginatedListQuery {
    private List<FilterCriteria> filterCriteriaList;
}
