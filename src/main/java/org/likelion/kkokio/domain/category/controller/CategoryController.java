package org.likelion.kkokio.domain.category.controller;

import lombok.RequiredArgsConstructor;
import org.likelion.kkokio.domain.category.dto.request.CategoryInfoRequestDTO;
import org.likelion.kkokio.domain.category.dto.response.CategoryInfoResponseDTO;
import org.likelion.kkokio.domain.category.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/info/{storeId}")
    public ResponseEntity<CategoryInfoResponseDTO> createCategoryInfo(
            @PathVariable Long storeId,
            @RequestBody CategoryInfoRequestDTO categoryInfoRequestDTO
    ) {
        return categoryService.createCategoryInfo(storeId, categoryInfoRequestDTO);
    }

    @PutMapping("/info/{categoryId}")
    public ResponseEntity<CategoryInfoResponseDTO> updateCategoryInfo(
            @PathVariable Long categoryId,
            @RequestBody CategoryInfoRequestDTO categoryInfoRequestDTO
    ) {
        return categoryService.updateCategoryInfo(categoryId, categoryInfoRequestDTO);
    }

    @DeleteMapping("/info/{categoryId}")
    public ResponseEntity<Void> deleteCategoryInfo(@PathVariable Long categoryId) {
        return categoryService.deleteCategoryInfo(categoryId);
    }

    @GetMapping("/info/{storeId}")
    public ResponseEntity<List<CategoryInfoResponseDTO>> getCategoryInfo(@PathVariable Long storeId) {
        return categoryService.getCategoryInfo(storeId);
    }
}
