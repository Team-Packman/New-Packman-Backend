package org.packman.pack;

import org.packman.pack.domain.Pack;
import org.packman.pack.dto.request.PackPosition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackService {

    private final PackRepository packRepository;

    public PackService(PackRepository packRepository) {
        this.packRepository = packRepository;
    }

    @Transactional
    public void create(Pack pack) {
        List<Pack> packs = packRepository.findAllByCategoryIdOrderByPosition(pack.getCategoryId());
        int position = 1;

        if(!packs.isEmpty()) {
            Pack last = packs.getLast();
            position = last.getPosition() + 1;
        }

        Pack update = pack.updatePosition(position);
        packRepository.save(update);
    }

    @Transactional
    public void updatePosition(PackPosition packPosition) {
        Pack originalPack = packRepository.findById(packPosition.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 짐입니다."));

        packOut(originalPack);

        Pack updatePack = originalPack.updatePositionAndCategory(
                packPosition.getCategoryId(),
                packPosition.getPosition()
        );

        packIn(updatePack);
    }

    public void packOut(Pack packBeforeMove) {
        List<Pack> packs = packRepository.findByCategoryIdAndPositionGreaterThan(
                packBeforeMove.getCategoryId(),
                packBeforeMove.getPosition()
        );

        List<Pack> updatePacks = new ArrayList<>();

        for (Pack pack : packs) {
            Pack updatePack = pack.updatePosition(pack.getPosition() - 1);
            updatePacks.add(updatePack);
        }

        Pack originalPack = packBeforeMove.updatePosition(null);
        updatePacks.add(originalPack);

        packRepository.saveAll(updatePacks);
    }

    private void packIn(Pack packAfterMove) {
        List<Pack> packs = packRepository.findByCategoryIdAndPositionGreaterThanEqual(
                packAfterMove.getCategoryId(),
                packAfterMove.getPosition()
        );

        List<Pack> updatePacks = new ArrayList<>();

        for (Pack pack : packs) {
            Pack updatePack = pack.updatePosition(pack.getPosition() + 1);
            updatePacks.add(updatePack);
        }

        updatePacks.add(packAfterMove);

        packRepository.saveAll(updatePacks);
    }

    @Transactional(readOnly = true)
    public List<Pack> getPacksByCategoryId(Long categoryId) {
        return packRepository.findAllByCategoryIdOrderByPosition(categoryId);
    }

}
