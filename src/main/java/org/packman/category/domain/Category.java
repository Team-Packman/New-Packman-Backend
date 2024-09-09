package org.packman.category.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String name;

    @Getter
    private Integer position;

    @Getter
    private Long packingListId;

    @Builder
    private Category(
            Long id,
            String name,
            Integer position,
            Long packingListId
    ) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.packingListId = packingListId;
    }

    public CategoryBuilder category() {
        return new CategoryBuilder()
                .id(this.id)
                .name(this.name)
                .position(this.position)
                .packingListId(this.packingListId);
    }

    public Category updatePosition(Integer position) {
        return category()
                .id(null)
                .position(position)
                .build();
    }

}