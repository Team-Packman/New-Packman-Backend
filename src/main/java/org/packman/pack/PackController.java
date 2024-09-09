package org.packman.pack;

import org.packman.pack.dto.request.PackPosition;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/packs")
public class PackController {

    private final PackService packService;

    private PackController(PackService packService) {
        this.packService = packService;
    }

    @PostMapping
    public void create(@RequestBody PackCreate request) {
        packService.create(request.toEntity());
    }

    @PatchMapping("/position")
    public void updatePosition(@RequestBody PackPosition request) {
        packService.updatePosition(request);
    }

}
