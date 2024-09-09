package org.packman.pack;

import org.packman.pack.domain.Pack;

public record PackCreate(
        String name,
        Long categoryId
) {
    public Pack toEntity() {
        return Pack.builder()
                .name(name)
                .categoryId(categoryId)
                .build();
    }
}
