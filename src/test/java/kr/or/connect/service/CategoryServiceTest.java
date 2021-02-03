package kr.or.connect.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import kr.or.connect.dao.CategoryDao;
import kr.or.connect.dto.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryDao categoryDao;

    @Test
    void 전체다가져와지는지테스트() {
        //given
        Category category = new Category();
        category.setName("정명훈");
        category.setCount(97);
        List<Category> list = Collections.singletonList(category);
        when(categoryDao.selectAll()).thenReturn(list);
        //when
        final Map<String, Object> map = categoryService.selectAllCategoriesAndCount();
        //then
        Assertions.assertNotNull(map);
        Assertions.assertEquals(1, (Integer) map.get("size"));
    }

}
