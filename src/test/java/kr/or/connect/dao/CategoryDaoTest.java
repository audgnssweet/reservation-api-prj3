package kr.or.connect.dao;

import java.util.List;
import kr.or.connect.config.ApplicationConfig;
import kr.or.connect.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(ApplicationConfig.class)
public class CategoryDaoTest {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryDaoTest(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Test
    void selectAll() {
        final List<Category> categories = categoryDao.selectAll();
        categories.forEach(System.out::println);
    }

    @Test
    void getCount() {
        final List<Integer> displayCount = categoryDao.getDisplayCount();
        displayCount.forEach(System.out::println);
    }

}
