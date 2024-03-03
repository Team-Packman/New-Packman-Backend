package org.packman.packingList;

import org.packman.category.Category;
import org.packman.category.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PackingListService {

    private final CategoryService categoryService;

    public PackingListService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public List<Category> getCategories(Long packingListId) {
        return categoryService.getAllByPackingListId(packingListId);
    }
}
