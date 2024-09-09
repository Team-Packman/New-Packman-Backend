package org.packman.category;

import org.packman.pack.domain.Pack;
import org.packman.pack.dto.response.PackGet;
import org.packman.packingList.dto.response.PackingListCreate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.packman.packingList.domain.Type.ALONE;
import static org.packman.packingList.domain.Type.TOGETHER;

@RestController
@RequestMapping("/api/v2/categories")
public class CategoryController {

    private final CategoryService categoryService;

    private CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public void create(@RequestBody CategoryCreate request) {
        categoryService.create(request.toEntity());
    }

    @GetMapping("/{categoryId}/packs")
    public List<PackGet> get(@PathVariable Long categoryId) {
        List<Pack> packs = categoryService.getPacks(categoryId);

        return packs.stream()
                .map(PackGet::from)
                .toList();
    }

}
