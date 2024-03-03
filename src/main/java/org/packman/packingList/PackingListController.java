package org.packman.packingList;

import org.packman.category.Category;
import org.packman.category.dto.response.CategoryGet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/packingLists")
public class PackingListController {

    private final PackingListService packingListService;

    public PackingListController(PackingListService packingListService) {
        this.packingListService = packingListService;
    }

    @GetMapping("/{packingLIstId}/categories")
    public List<CategoryGet> get(@PathVariable Long packingLIstId) {
        List<Category> categories = packingListService.getCategories(packingLIstId);

        return categories.stream()
                .map(CategoryGet::from)
                .toList();
    }
}
