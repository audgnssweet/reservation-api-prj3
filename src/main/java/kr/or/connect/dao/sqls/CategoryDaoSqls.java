package kr.or.connect.dao.sqls;

public class CategoryDaoSqls {

    public static final String SELECT_CATEGORY_DISPLAY_COUNT =
        "select count(*) as count from ("
            + "select category.id, product.description, display_info.place_name "
            + "from category "
            + "left outer join product on category.id = product.category_id "
            + "left outer join display_info on product.id = display_info.product_id "
            + ")result group by id;";

    public static final String SELECT_ALL =
        "select id, name from category;";

}
