package org.packman.packingList.dto.response;

import org.packman.packingList.domain.PackingList;
import org.packman.packingList.domain.Type;

import java.time.LocalDate;

public record PackingListCreate(
        String title,
        LocalDate departureDate,
        Type type
) {
    public PackingList toEntity() {
        return PackingList.builder()
                .title(title)
                .departureDate(departureDate)
                .build();
    }
}

