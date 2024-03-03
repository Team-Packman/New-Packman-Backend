package org.packman.user.dto.response;

import org.packman.packingList.PackingList;

public record PackingListGet(Long id, String name) {

    public static PackingListGet from(PackingList packingList) {
        return new PackingListGet(packingList.getId(), packingList.getTitle());
    }

}
