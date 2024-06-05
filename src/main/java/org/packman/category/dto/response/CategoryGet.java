package org.packman.category.dto.response;

import lombok.Builder;
import org.packman.category.domain.Category;
import org.packman.pack.domain.Pack;

import java.util.List;

@Builder
public record CategoryGet(
        Long id,
        String name,
        int totalCnt,
        int checkedCnt,
        Long parent,
        String type
) {

    public static final String CATEGORY = "category";

    public static CategoryGet from(Category category, List<Pack> packs) {
        int totalCnt = packs.size();
        int checkedCnt = (int) packs.stream().filter(Pack::isChecked).count();

        return CategoryGet.builder()
                .id(category.getId())
                .name(category.getName())
                .totalCnt(totalCnt)
                .checkedCnt(checkedCnt)
                .parent(null)
                .type(CATEGORY)
                .build();
    }
}
