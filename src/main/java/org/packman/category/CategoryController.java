package org.packman.category;

import org.packman.pack.Pack;
import org.packman.pack.dto.response.PackGet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/categories")
public class CategoryController {

    private final CategoryService categoryService;

    private CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{categoryId}/packs")
    public List<PackGet> get(@PathVariable Long categoryId) {
        List<Pack> packs = categoryService.getPacks(categoryId);

        return packs.stream()
                .map(PackGet::from)
                .toList();
    }

}
