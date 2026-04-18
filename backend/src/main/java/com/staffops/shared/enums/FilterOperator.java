package com.staffops.shared.enums;

public enum FilterOperator {
    EQUALS("=="),
    GREATER_THAN(">"),
    LESS_THAN("<"),
    GREATER_THAN_OR_EQUALS(">="),
    LESS_THAN_OR_EQUALS("<="),
    CONTAINS("contains");

    private final String value;

    FilterOperator(String value) {
        this.value = value;
    }

    public static FilterOperator fromValue(String value) {
        for (FilterOperator op : FilterOperator.values()) {
            if (op.value.equals(value)) {
                return op;
            }
        }

        throw new IllegalArgumentException("Unknown FilterOperator value: " + value);
    }

    public String getValue() {
        return value;
    }
}
