package org.packman.pack.domain;

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
public class Pack {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String name;

    @Getter
    private Long categoryId;

    @Getter
    private boolean checked;

    @Getter
    private Integer position;

    @Builder
    private Pack(Long id, String name, Long categoryId, Integer position, boolean checked) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.position = position;
        this.checked = checked;
    }

    public PackBuilder pack() {
        return new PackBuilder()
                .id(this.id)
                .name(this.name)
                .categoryId(this.categoryId)
                .checked(this.checked)
                .position(this.position);
    }

    public Pack updatePositionAndCategory(Long categoryId, Integer position) {
        return pack()
                .categoryId(categoryId)
                .position(position)
                .build();
    }

    public Pack updatePosition(Integer position) {
        return pack()
                .id(null)
                .position(position)
                .build();
    }
}
