package org.packman.pack.dto.response;

import lombok.Builder;
import org.packman.pack.domain.Pack;

@Builder
public record PackGet(
        Long id,
        String name,
        boolean checked,
        Long parent,
        String type
) {

    public static final String PACK = "pack";

    public static PackGet from(Pack pack) {
        return PackGet.builder()
                .id(pack.getId())
                .name(pack.getName())
                .checked(pack.isChecked())
                .parent(pack.getCategoryId())
                .type(PACK)
                .build();
    }
}
