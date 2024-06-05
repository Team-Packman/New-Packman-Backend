package org.packman.packingList;

import org.packman.category.CategoryService;
import org.packman.category.domain.Category;
import org.packman.category.dto.response.CategoryGet;
import org.packman.pack.domain.Pack;
import org.packman.packingList.domain.PackingList;
import org.packman.packingList.dto.request.PackingListPosition;
import org.packman.packingList.dto.response.PackingListGet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/packing-lists")
public class PackingListController {

    private final PackingListService packingListService;
    private final CategoryService categoryService;

    public PackingListController(PackingListService packingListService, CategoryService categoryService) {
        this.packingListService = packingListService;
        this.categoryService = categoryService;
    }

    @GetMapping("/{packingLIstId}/categories")
    public List<CategoryGet> getCategories(@PathVariable Long packingLIstId) {
        List<Category> categories = packingListService.getCategories(packingLIstId);

        return categories.stream()
                .map(category -> {
                    List<Pack> packs = categoryService.getPacks(category.getId());
                    return CategoryGet.from(category, packs);
                })
                .toList();
    }

    @PatchMapping("/position")
    public void updatePosition(@RequestBody PackingListPosition request) {
        packingListService.updatePosition(request);
    }

    @GetMapping("/{packingListId}")
    public PackingListGet get(@PathVariable Long packingListId) {
        PackingList packingList = packingListService.get(packingListId);

        return PackingListGet.from(packingList);
    }

}