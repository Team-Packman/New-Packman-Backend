package org.packman.pack.dto.response;

import org.packman.pack.Pack;

public record PackGet(Long id, String name) {
    public static PackGet from(Pack pack) {
        return new PackGet(pack.getId(), pack.getName());
    }
}
