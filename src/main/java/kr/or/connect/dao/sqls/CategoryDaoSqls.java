package kr.or.connect.dao.sqls;

public class CategoryDaoSqls {

    public static final String SELECT_ALL =
        "select category.id, category.name, t.count\n"
            + "from category\n"
            + "inner join\n"
            + "(select id, count(*) as count from (\n"
            + "select category.id, product.description, display_info.place_name\n"
            + "from category\n"
            + "left outer join product on category.id = product.category_id\n"
            + "left outer join display_info on product.id = display_info.product_id\n"
            + ")result\n"
            + "group by id)t\n"
            + "on category.id = t.id;";
}
