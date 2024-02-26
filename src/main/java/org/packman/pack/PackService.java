package org.packman.pack;

import org.packman.pack.dto.request.PackPosition;
import org.springframework.stereotype.Service;

@Service
public class PackService {

    private final PackRepository packRepository;

    private PackService(PackRepository packRepository) {
        this.packRepository = packRepository;
    }

    public void updatePosition(PackPosition packPosition) {
        Pack pack = packRepository.findById(packPosition.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 짐입니다."));

        Pack updatePack = pack.updatePosition(
                packPosition.getCategoryId(),
                packPosition.getPosition()
        );

        packRepository.save(updatePack);
    }
}
