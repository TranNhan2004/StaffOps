package com.staffops.shared.models.filters;

import com.staffops.shared.models.pagination.PaginatedListResult;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilterResult<T> extends PaginatedListResult<T> {
}
