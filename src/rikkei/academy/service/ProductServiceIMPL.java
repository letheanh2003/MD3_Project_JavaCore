package rikkei.academy.service;

import rikkei.academy.config.Config;
import rikkei.academy.model.Product;
import rikkei.academy.service.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProductService {
    private List<Product> listProducts = new Config<Product>().readFromFile(Config.PATH_PRODUCT);
    @Override
    public List<Product> findAll() {
        return listProducts;
    }

    @Override
    public void save(Product product) {
        if (findById(product.getProductId()) == null){
            // thêm mới
            listProducts.add(product);
        }else {
            // cập nhật
            int index = listProducts.indexOf(findById(product.getProductId()));
            listProducts.set(index,product);
        }
        // cập nhật lại dữ liệu trong file
        new Config<Product>().writeToFile(Config.PATH_PRODUCT,listProducts);

    }

    @Override
    public Product findById(int id) {
        for (Product p: listProducts) {
            if (p.getProductId()==id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        listProducts.remove(findById(id));
        new Config<Product>().writeToFile(Config.PATH_PRODUCT,listProducts);
    }
    public List<Product> searchProductsByName(String name){
        List<Product> listSearch = new ArrayList<>();
        for (Product p : listProducts) {
            if(p.getProductName().toLowerCase().contains(name.toLowerCase())){
                listSearch.add(p);
            }
        }
        return listSearch;
    }
}
