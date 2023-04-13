package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.controller.CategoryController;
import rikkei.academy.model.Category;

import java.util.List;

import static rikkei.academy.config.Config.scanner;

public class CategoryView {
    CategoryController categoryController = new CategoryController();
    List<Category> categoryList = categoryController.getListCategory();

    public void showFormCategoryList() {
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |                                                                                                    |");
        System.out.println("       *------------------------------------------ TABLE CATEGORY ------------------------------------------*");

        System.out.println("       ID  - NAME : ");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println("       ID " + categoryList.get(i).getId() + " - NAME: " + categoryList.get(i).getName());
            System.out.println("       *----------------------------------------------------------------------------------------------------*");
        }
        System.out.print("       Enter any key to continue or 'back' to return Menu: ");;
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Navbar();
        }
    }

    public void formCreateCategory() {
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |                                                                                                    |");
        System.out.println("       *--------------------------------------- CREATE CATEGORY LIST ---------------------------------------*");
        while (true) {
            int id = 0;
            if (categoryList.size() == 0) {
                id = 1;
            } else {
                id = categoryList.get(categoryList.size() - 1).getId() + 1;
            }
            System.out.print("       Enter the name: ");
            String name = scanner().nextLine();
            System.out.println("       *----------------------------------------------------------------------------------------------------*");
            Category category = new Category(id, name);
            categoryController.createCategoryToDB(category);
            System.out.println("       Create Success!");
            System.out.print("       Enter the any key to continue or Enter back to return Menu: ");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
                new Navbar();
                break;
            }
        }

    }

    public void formUpdateCategory() {
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |                                                                                                    |");
        System.out.println("       *--------------------------------------- UPDATE CATEGORY LIST ---------------------------------------*");
        while (true) {
            System.out.print("       Enter the id to update: ");
            int id = scanner().nextInt();
            System.out.println("       *----------------------------------------------------------------------------------------------------*");
            if (categoryController.detailCategory(id) == null) {
                System.err.println("       Id not found! Please try again!");
//                id = Config.scanner().nextInt();
            } else {
                System.out.print("       Enter the name: ");
                String name = scanner().nextLine();
                System.out.println("       *----------------------------------------------------------------------------------------------------*");
                Category category = new Category(id, name);
                categoryController.updateCategory(category);
                System.out.println("       Update success!");
                System.out.print("       Enter the any key to continue or Enter back to return Menu: ");
                String backMenu = Config.scanner().nextLine();
                if (backMenu.equalsIgnoreCase("back")) {
                    new Navbar();
                    break;
                }
            }
        }
    }

    public void deleteByIdCategory() {
        showFormCategoryList();
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |                                                                                                    |");
        System.out.println("       *--------------------------------------- DELETE CATEGORY LIST ---------------------------------------*");
        System.out.print("       Enter id to delete: ");
        int id = Integer.parseInt(Config.scanner().nextLine());
        categoryController.deleteById(id);
    }

    public static void formSearchCategory() {
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |                                                                                                    |");
        System.out.println("       *------------------------------------- SEARCH CATEGORY BY NAME --------------------------------------*");
        System.out.print("       Enter category name: ");
        String name = Config.scanner().nextLine();

        CategoryController categoryController = new CategoryController();
        List<Category> listSearch = categoryController.searchCategoryByName(name);
        if (listSearch.size() == 0) {
            System.out.println("       Category not found!!!");
        } else {
            for (Category category : listSearch) {
                System.out.println("       ------------------------------------------------------------------------------------------------------");
                System.out.println(category);
            }
        }
    }
}

