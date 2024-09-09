package org.packman.category;

import org.packman.category.domain.Category;
import org.packman.pack.PackService;
import org.packman.pack.domain.Pack;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CategoryService {

    private final PackService packService;

    private final CategoryRepository categoryRepository;

    public CategoryService(PackService packService, CategoryRepository categoryRepository) {
        this.packService = packService;
        this.categoryRepository = categoryRepository;
    }

    public void create(Category category) {
        List<Category> categories = categoryRepository.findAllByPackingListIdOrderByPosition(category.getPackingListId());
        int position = 1;

        if(!categories.isEmpty()) {
            Category last = categories.getLast();
            position = last.getPosition() + 1;
        }

        Category update = category.updatePosition(position);
        categoryRepository.save(update);
    }

    public List<Pack> getPacks(Long categoryId) {
        return packService.getPacksByCategoryId(categoryId);
    }

    public List<Category> getAllByPackingListId(Long id) {
        return categoryRepository.findAllByPackingListIdOrderByPosition(id);
    }

}
