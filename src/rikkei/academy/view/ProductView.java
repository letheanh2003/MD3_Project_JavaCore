package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.controller.ProductController;
import rikkei.academy.model.Category;
import rikkei.academy.model.Product;

import java.util.List;

public class ProductView {
    private ProductController productController = new ProductController();
    private List<Product> productList = productController.getListProducts();
    private List<Category> categoryList = new Config<Category>().readFromFile(Config.PATH_CATEGORY);

    public void showListProduct() {
        if (productList.size() == 0) {
            System.out.println("       Không có sản phẩm nào hết.");
        } else {
            for (Product product : productList) {
                System.out.println("       --------------------------------------------------------------------");
                System.out.println("       " + product);
            }
        }
    }

    public void formCreateProduct() {
        System.out.println("       Enter number of product want to create: ");
        int number = Config.scanner().nextInt();
        for (int i = 0; i < number; i++) {
            System.out.println("       Enter product: " + (i + 1));

            Product newProduct = new Product();
            if (productList.size() == 0) {
                newProduct.setProductId(1);
            } else {
                newProduct.setProductId(productList.get(productList.size() - 1).getProductId() + 1);
            }
            System.out.print("       Enter product name: ");
            newProduct.setProductName(Config.scanner().nextLine());
            System.out.print("       Enter description: ");
            newProduct.setDescription(Config.scanner().nextLine());
            System.out.print("       Enter price: ");
            newProduct.setPrice(Config.scanner().nextFloat());
            newProduct.setStatus(true);
            // chọn danh mục cho sản phẩm
            for (Category cat : categoryList
            ) {
                System.out.printf("       ID:%d  - Name:%s \n", cat.getId(), cat.getName());
            }

            while (true) {
                boolean check = false;
                System.out.print("       Enter category Id: ");
                int idCat = Config.scanner().nextInt();
                for (Category cat : categoryList) {
                    if (cat.getId() == idCat) {
                        newProduct.setCategory(cat);
                        check = true;
                    }
                }
                if (!check) {
                    System.err.println("       Not match any categoryId, please try again!");
                } else {
                    break;
                }
            }
            // tiến hành thêm vào danh sách
            productController.createProducts(newProduct);
            System.out.print("       Success!!!");
        }

    }

    public void updateProducts() {
        System.out.print("       Enter productId to edit: ");
        int idEdit = Config.scanner().nextInt();
        Product editProduct = productController.searchProductById(idEdit);
        if (editProduct == null) {
            System.err.print("       Product not found!!!");
        } else {
            System.out.print("       Enter new product name: ");
            editProduct.setProductName(Config.scanner().nextLine());
            System.out.print("       Enter new description: ");
            editProduct.setDescription(Config.scanner().nextLine());
            System.out.print("       Enter new price: ");
            editProduct.setPrice(Config.scanner().nextFloat());
            editProduct.setStatus(true);
            // chọn danh mục cho sản phẩm
            for (Category cat : categoryList
            ) {
                System.out.printf("ID:%d  - Name:%s \n", cat.getId(), cat.getName());
            }

            while (true) {
                boolean check = false;
                System.out.println("       Enter category Id: ");
                int idCat = Config.scanner().nextInt();
                for (Category cat : categoryList) {
                    if (cat.getId() == idCat) {
                        editProduct.setCategory(cat);
                        check = true;
                    }
                }
                if (!check) {
                    System.err.println("       Not match any categoryId, please try again!");
                } else {
                    break;
                }
            }
            productController.updateProduct(editProduct);
            System.out.println("       Success!!!");

        }
    }

    public void deleteProductById() {
        System.out.println("                      Enter productId to delete");
        int idDelete = Config.scanner().nextInt();
        Product productDelete = productController.searchProductById(idDelete);
        if (productDelete == null) {
            System.err.println("                  Not found product");
        } else {
            productController.deleteProduct(idDelete);
            System.out.println("                  Delete success");
        }
    }

    public void searchProductsByName() {
        System.out.println("                      Enter product name");
        String name = Config.scanner().nextLine();
        List<Product> listSearch = productController.searchProductsByName(name);
        if (listSearch.size() == 0) {
            System.out.println("                  Product not found");
        } else {
            for (Product product : listSearch) {
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println(product);
            }
        }
    }

}
