package org.packman.packingList.dto.response;

import org.packman.packingList.domain.OpenStatus;
import org.packman.packingList.domain.PackingList;

import java.time.LocalDate;

public record PackingListGet(
        Long id,
        String title,
        LocalDate departureDate,
        OpenStatus openStatus
) {
    public static PackingListGet from(PackingList packingList) {
        return new PackingListGet(
                packingList.getId(),
                packingList.getTitle(),
                packingList.getDepartureDate(),
                packingList.getOpenStatus()
        );
    }
}

