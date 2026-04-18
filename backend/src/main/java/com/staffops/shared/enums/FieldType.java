package com.staffops.shared.enums;

public enum FieldType {
    INT("int"),
    LONG("long"),
    FLOAT("float"),
    DOUBLE("double"),
    STRING("string"),
    INSTANT("datetime");

    private final String value;

    FieldType(String value) {
        this.value = value;
    }

    public static FieldType fromValue(String value) {
        for (FieldType op : FieldType.values()) {
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
