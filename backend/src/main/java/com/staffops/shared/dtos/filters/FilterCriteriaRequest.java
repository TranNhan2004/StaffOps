package com.staffops.shared.dtos.filters;

import com.staffops.shared.enums.FieldType;
import com.staffops.shared.enums.FilterOperator;
import com.staffops.shared.models.filters.FilterCriteria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FilterCriteriaRequest {
    private String fieldName;
    private FilterOperator operator;
    private FieldType type;
    private List<String> values;

    public static FilterCriteria toModel(FilterCriteriaRequest request) {
        FilterCriteria criteria = new FilterCriteria();
        criteria.setFieldName(request.getFieldName());
        criteria.setOperator(request.getOperator());
        criteria.setType(request.getType());
        criteria.setValues(request.getValues());
        return criteria;
    }
}
