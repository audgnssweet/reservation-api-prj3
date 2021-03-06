package kr.or.connect.controller;

import java.util.Map;
import kr.or.connect.dto.CategoryDto;
import kr.or.connect.dto.CategoryDto.Response;
import kr.or.connect.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public Response getCategories() {
        return categoryService.selectAllCategoriesAndCount();
    }

}
