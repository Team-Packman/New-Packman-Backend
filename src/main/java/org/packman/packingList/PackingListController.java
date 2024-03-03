package org.packman.packingList;

import org.packman.category.Category;
import org.packman.category.dto.response.CategoryGet;
import org.packman.packingList.request.PackingListPosition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/packingLists")
public class PackingListController {

    private final PackingListService packingListService;

    private PackingListController(PackingListService packingListService) {
        this.packingListService = packingListService;
    }


    @GetMapping("/{packingLIstId}/categories")
    public List<CategoryGet> get(@PathVariable Long packingLIstId) {
        List<Category> categories = packingListService.getCategories(packingLIstId);

        return categories.stream()
                .map(CategoryGet::from)
                .toList();
    }

    @PatchMapping("/position")
    public void updatePosition(@RequestBody PackingListPosition request) {
        packingListService.updatePosition(request);
    }

}