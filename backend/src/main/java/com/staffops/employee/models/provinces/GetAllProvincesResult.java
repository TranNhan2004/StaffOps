package com.staffops.employee.models.provinces;

import com.staffops.employee.entities.Province;
import com.staffops.shared.models.filters.FilterResult;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
final class ProvinceItem {
    private UUID id;
    private String name;

    public static ProvinceItem fromEntity(Province province) {
        ProvinceItem provinceItem = new ProvinceItem();
        provinceItem.setId(province.getId());
        provinceItem.setName(province.getName());
        return provinceItem;
    }
}

@Getter
@Setter
@NoArgsConstructor
public class GetAllProvincesResult extends FilterResult<ProvinceItem> {

    public static GetAllProvincesResult fromEntities(FilterResult<Province> provinces) {
        GetAllProvincesResult result = new GetAllProvincesResult();
        result.setItems(
            provinces
                .getItems()
                .stream()
                .map(ProvinceItem::fromEntity)
                .toList()
        );

        result.setPage(provinces.getPage());
        result.setSize(provinces.getSize());
        result.setTotalItems(provinces.getTotalItems());
        result.setTotalPages(provinces.getTotalPages());
        result.setHasNextPage(provinces.isHasNextPage());
        result.setHasPreviousPage(provinces.isHasPreviousPage());
        return result;
    }

}
