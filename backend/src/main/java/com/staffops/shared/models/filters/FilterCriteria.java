package com.staffops.shared.models.filters;

import com.staffops.shared.enums.FieldType;
import com.staffops.shared.enums.FilterOperator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FilterCriteria {
    private String fieldName;
    private FilterOperator operator;
    private FieldType type;
    private List<String> values;
}
