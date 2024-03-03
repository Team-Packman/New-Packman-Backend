package org.packman.category.dto.response;

import org.packman.category.Category;

public record CategoryGet(Long id, String name) {
    public static CategoryGet from(Category category) {
        return new CategoryGet(category.getId(), category.getName());
    }
}
