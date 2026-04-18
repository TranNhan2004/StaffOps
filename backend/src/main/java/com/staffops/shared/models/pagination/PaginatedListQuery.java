package com.staffops.shared.models.pagination;

import com.staffops.shared.exceptions.ValidationException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PaginatedListQuery {
    private int page;
    private int size;
    
    public void setSize(int size) {
        if (size < 0)
            throw new ValidationException("size must be greater than 0.");

        this.size = size;
    }

    public void setPage(int page) {
        if (page < 0)
            throw new ValidationException("page must be greater than 0.");

        this.page = page;
    }
}
