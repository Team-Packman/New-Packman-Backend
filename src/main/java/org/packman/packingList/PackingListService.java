package org.packman.packingList;

import org.packman.category.Category;
import org.packman.category.CategoryService;
import org.packman.packingList.request.PackingListPosition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackingListService {

    private final PackingListRepository packingListRepository;

    private final CategoryService categoryService;

    public PackingListService(PackingListRepository packingListRepository, CategoryService categoryService) {
        this.packingListRepository = packingListRepository;
        this.categoryService = categoryService;
    }

    @Transactional(readOnly = true)
    public List<Category> getCategories(Long packingListId) {
        return categoryService.getAllByPackingListId(packingListId);
    }

    @Transactional
    public void updatePosition(PackingListPosition packingListPosition) {
        PackingList originalPackingList = packingListRepository.findById(packingListPosition.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 패킹리스트입니다."));

        packingListOut(originalPackingList);

        PackingList updatePackingList = originalPackingList.updatePosition(
                packingListPosition.getPosition()
        );

        packingListIn(updatePackingList);
    }

    public void packingListOut(PackingList packingListBeforeMove) {
        List<PackingList> packingLists = packingListRepository.findByPositionGreaterThan(
                packingListBeforeMove.getPosition()
        );

        List<PackingList> updatedPackingLists = new ArrayList<>();

        for (PackingList packingList : packingLists) {
            PackingList updatePackingList = packingList.updatePosition(packingList.getPosition() - 1);
            updatedPackingLists.add(updatePackingList);
        }

        PackingList originalPackingList = packingListBeforeMove.updatePosition(null);

        updatedPackingLists.add(originalPackingList);

        packingListRepository.saveAll(updatedPackingLists);
    }

    private void packingListIn(PackingList packingListAfterMove) {
        List<PackingList> packingLists = packingListRepository.findByPositionGreaterThanEqual(
                packingListAfterMove.getPosition()
        );

        List<PackingList> updatePacks = new ArrayList<>();

        for (PackingList packingList : packingLists) {
            PackingList updatePack = packingList.updatePosition(packingList.getPosition() + 1);
            updatePacks.add(updatePack);
        }

        updatePacks.add(packingListAfterMove);

        packingListRepository.saveAll(updatePacks);
    }

    @Transactional(readOnly = true)
    public List<PackingList> getAllByUserId(Long userId) {
        return packingListRepository.findAllByUserIdOrderByPosition(userId);
    }

}