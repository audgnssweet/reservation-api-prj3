package kr.or.connect.dao;

import static kr.or.connect.dao.sqls.CategoryDaoSqls.SELECT_ALL;
import static kr.or.connect.dao.sqls.CategoryDaoSqls.SELECT_CATEGORY_DISPLAY_COUNT;

import java.util.Collections;
import java.util.List;
import javax.sql.DataSource;
import kr.or.connect.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao {

    private final NamedParameterJdbcTemplate template;
    private final RowMapper<Category> mapper;

    @Autowired
    public CategoryDao(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
        mapper = new BeanPropertyRowMapper<>(Category.class);
    }

    public List<Category> selectAll() {
        return template.query(SELECT_ALL, Collections.emptyMap(), mapper);
    }

    public List<Integer> getDisplayCount() {
        return template.queryForList(SELECT_CATEGORY_DISPLAY_COUNT, Collections.emptyMap(), Integer.class);
    }

}
