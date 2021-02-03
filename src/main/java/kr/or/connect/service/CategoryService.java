package kr.or.connect.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kr.or.connect.dao.CategoryDao;
import kr.or.connect.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Transactional(readOnly = true)
    public Map<String, Object> selectAllCategoriesAndCount() {
        final List<Category> categories = categoryDao.selectAll();
        Map<String, Object> map = new HashMap<>();
        map.put("size", categories.size());
        map.put("items", categories);
        return map;
    }

}
