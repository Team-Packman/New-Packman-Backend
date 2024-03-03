package org.packman.packingList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PackingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer position;

    private String title;

    private Long userId;

    @Builder
    public PackingList(Long id, Integer position, String title, Long userId) {
        this.id = id;
        this.position = position;
        this.title = title;
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

    public Long getId() {
        return id;
    }

    public Integer getPosition() {
        return position;
    }

    public String getTitle() {
        return title;
    }
}

