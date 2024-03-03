package org.packman.pack;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long categoryId;

    private Integer position;

    @Builder
    private Pack(Long id, String name, Long categoryId, Integer position) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.position = position;
    }

    public Pack updatePositionAndCategory(Long categoryId, Integer position) {
        return Pack.builder()
                .id(this.id)
                .name(this.name)
                .categoryId(categoryId)
                .position(position)
                .build();
    }

    public Pack updatePosition(Integer position) {
        return Pack.builder()
                .id(this.id)
                .name(this.name)
                .categoryId(this.categoryId)
                .position(position)
                .build();
    }

    public Long getId() {
        return id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Integer getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
