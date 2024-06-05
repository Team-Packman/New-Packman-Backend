package org.packman.user.dto.response;

import org.packman.packingList.domain.PackingList;

public record PackingListGet(Long id, String name) {

    public static PackingListGet from(PackingList packingList) {
        return new PackingListGet(packingList.getId(), packingList.getTitle());
    }

}
