package rikkei.academy.service;

import rikkei.academy.model.Category;
import rikkei.academy.service.IGenericService;

import java.util.List;

public interface ICategoryService extends IGenericService<Category> {
    List<Category> searchCategoryByName(String name);
}
