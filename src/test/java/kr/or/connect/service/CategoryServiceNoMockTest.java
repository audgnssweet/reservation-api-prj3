package kr.or.connect.service;

import kr.or.connect.config.ApplicationConfig;
import kr.or.connect.dto.CategoryDto.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(ApplicationConfig.class)
public class CategoryServiceNoMockTest {

    private final CategoryService categoryService;

    @Autowired
    public CategoryServiceNoMockTest(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Test
    void 다가져와지는지() {
        final Response response = categoryService.selectAllCategoriesAndCount();
        System.out.println(response);
    }
}
