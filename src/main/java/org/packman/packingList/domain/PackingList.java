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
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PackingList {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Builder.Default
    private Integer position = 1;

    @Getter
    private String title;

    @Getter
    private LocalDate departureDate;

    @Getter
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private OpenStatus openStatus = OpenStatus.PUBLIC;

    private Long parentId;

    private Long userId;

    public PackingList(
            Long id,
            Integer position,
            String title,
            LocalDate departureDate,
            OpenStatus openStatus,
            Long parentId,
            Long userId
    ) {
        this.id = id;
        this.position = position;
        this.title = title;
        this.departureDate = departureDate;
        this.openStatus = openStatus;
        this.parentId = parentId;
        this.userId = userId;
    }

    public PackingListBuilder packingList() {
        return new PackingListBuilder()
                .id(this.id)
                .position(this.position)
                .title(this.title)
                .departureDate(this.departureDate)
                .openStatus(this.openStatus)
                .parentId(this.parentId)
                .userId(this.userId);
    }

    public PackingList updatePosition(Integer position) {
        return packingList()
                .position(position)
                .build();
    }

    public PackingList updateParentId(Long parentId) {
        return packingList()
                .id(null)
                .parentId(parentId)
                .build();
    }

}

