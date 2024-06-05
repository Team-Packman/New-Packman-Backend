package org.packman.packingList.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PackingList {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private Integer position;

    @Getter
    private String title;

    @Getter
    private LocalDate departureDate;

    @Getter
    @Enumerated(EnumType.STRING)
    private OpenStatus openStatus = OpenStatus.PUBLIC;

    private Long userId;

    @Builder
    public PackingList(
            Long id,
            Integer position,
            String title,
            LocalDate departureDate,
            OpenStatus openStatus,
            Long userId
    ) {
        this.id = id;
        this.position = position;
        this.title = title;
        this.departureDate = departureDate;
        this.openStatus = openStatus;
        this.userId = userId;
    }

    public PackingList updatePosition(Integer position) {
        return PackingList.builder()
                .id(this.id)
                .position(position)
                .title(this.title)
                .userId(this.userId)
                .build();
    }

}

