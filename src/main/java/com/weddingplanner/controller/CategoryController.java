package com.weddingplanner.controller;

import com.weddingplanner.entity.Category;
import com.weddingplanner.response.OfferResponse;
import com.weddingplanner.services.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Object> getAllCategory() {
        return ResponseEntity.ok().body(categoryService.findAllCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(categoryService.getCategory(id));
    }

    @PostMapping
    public ResponseEntity<Object> createCategory(@RequestBody Category category) {
        try {
            return ResponseEntity.ok(categoryService.createCategory(category));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new OfferResponse("Not good data",
                    "You didn't provide accurate data."));
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> updateCategory(
            @PathVariable(value = "id") Long id,
            @RequestBody Category category) {
        return ResponseEntity.ok(categoryService.updateCategory(id, category));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(
            @PathVariable(value = "id") Long id) {
        categoryService.deleteCategory(id);
    }
}
