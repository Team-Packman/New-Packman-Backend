package org.packman.pack;

import org.packman.pack.dto.request.PackPosition;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/packs")
public class PackController {

    private final PackService packService;

    private PackController(PackService packService) {
        this.packService = packService;
    }

    @PatchMapping("/position")
    public void updatePosition(@RequestBody PackPosition request) {
        packService.updatePosition(request);
    }

}
