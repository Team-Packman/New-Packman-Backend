package org.packman.category;

import org.packman.category.domain.Category;

public record CategoryCreate(
        String name,
        Long packingListId
) {
    public Category toEntity() {
        return Category.builder()
                .name(name)
                .packingListId(packingListId)
                .build();
    }
}

