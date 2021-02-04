package kr.or.connect.dto;

import java.util.List;

public class CategoryDto {

    public static class Item {
        private Integer id;
        private String name;
        private Integer count;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
        }
    }

    public static class Response {
        private Integer size;
        private List<CategoryDto.Item> items;

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }

        @Override
        public String toString() {
            return "Response{" +
                "size=" + size +
                ", items=" + items +
                '}';
        }
    }

}
