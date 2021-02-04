package kr.or.connect.service;

import java.util.ArrayList;
import java.util.List;
import kr.or.connect.dao.CategoryDao;
import kr.or.connect.domain.Category;
import kr.or.connect.dto.CategoryDto;
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
    public CategoryDto.Response selectAllCategoriesAndCount() {
        //데이터 얻어오기
        final List<Category> categories = categoryDao.selectAll();
        final List<Integer> counts = categoryDao.getDisplayCount();
        //데이터 가공
        List<CategoryDto.Item> items = new ArrayList<>();
        makeCategoryToInfo(categories, items);
        setCountToInfo(counts, items);

        //map으로 감싸서 return
        CategoryDto.Response response = new CategoryDto.Response();
        response.setSize(items.size());
        response.setItems(items);
        return response;
    }

    private void setCountToInfo(List<Integer> counts, List<CategoryDto.Item> items) {
        for (int i = 0; i < items.size(); i++) {
            items.get(i).setCount(counts.get(i));
        }
    }

    private void makeCategoryToInfo(List<Category> categories, List<CategoryDto.Item> items) {
        categories.forEach(category -> {
            CategoryDto.Item item = new CategoryDto.Item();
            item.setId(category.getId());
            item.setName(category.getName());
            items.add(item);
        });
    }

}
