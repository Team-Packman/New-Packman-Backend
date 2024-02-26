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

    private int position;

    @Builder
    private Pack(Long id, String name, Long categoryId, int position) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.position = position;
    }

    public Pack updatePosition(Long categoryId, int position) {
        return Pack.builder()
                .id(this.id)
                .name(this.name)
                .categoryId(categoryId)
                .position(position)
                .build();
    }
}
