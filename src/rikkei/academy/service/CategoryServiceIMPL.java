package rikkei.academy.service;

import rikkei.academy.config.Config;
import rikkei.academy.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceIMPL implements ICategoryService {
    List<Category> categoryList = new Config<Category>().readFromFile(Config.PATH_CATEGORY);

    @Override
    public List<Category> searchCategoryByName(String name) {
        List<Category> listSearch = new ArrayList<>();
        for (Category category : categoryList) {
            if (category.getName().toLowerCase().contains(name.toLowerCase())) {
                listSearch.add(category);
            }
        }
        return listSearch;
    }

    @Override
    public List<Category> findAll() {
        return categoryList;
    }

    @Override
    public void save(Category category) {
        if (findById(category.getId()) == null) {
            categoryList.add(category);
        } else {
            categoryList.set(categoryList.indexOf(findById(category.getId())), category);
        }
        new Config<Category>().writeToFile(Config.PATH_CATEGORY, categoryList);
    }

    @Override
    public Category findById(int id) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getId() == id) {
                return categoryList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        categoryList.remove(findById(id));
        new Config<Category>().writeToFile(Config.PATH_CATEGORY, categoryList);
    }
}
