package rikkei.academy.view;




public class Navbar {
    public static void navbarHomePage(){
        System.out.println("       *------------------------------------------- SHOP BÁN HÀNG ------------------------------------------*");
        System.out.println("       |                    *************** (GI GỈ GÌ GI CÁI GÌ CŨNG BÁN) ***************                   |");
        System.out.println("       ------------------------------------------------------------------------------------------------------");
        System.out.println("       |                      1.  Login.                   |                 2. Register.                   |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |                                             3.  Exist.                                             |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |                                       (Nhập lựa chọn của bạn)                                      |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
    }
    public static void navbarAdmin(){
        System.out.println("       *---------------------------------------------- ADMIN -----------------------------------------------*");
        System.out.println("       ------------------------------------------------------------------------------------------------------");
        System.out.println("       |       1. Category Management.                   |                 2. Product Management.           |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |       3. User Management.                       |                 4. Order Management.             |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |       5. FeedBack..                             |                 6. Exist.                        |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |                                      (Nhập lựa chọn của bạn)                                       |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");

    }

    // Admin
    public static void navbarCategoryManager() {
        System.out.println("       *----------------------------------------- ADMIN CATEGORY -------------------------------------------*");
        System.out.println("       ------------------------------------------------------------------------------------------------------");
        System.out.println("       |       1. Show list category.                   |                 2. Create new category.           |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |       3. Update category.                      |                 4. Delete category.               |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |                                            5. Exist.                                               |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |                                      (Nhập lựa chọn của bạn)                                       |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
    }
    public static void navbarProductManager() {
        System.out.println("       *----------------------------------------- ADMIN PRODUCT --------------------------------------------*");
        System.out.println("       ------------------------------------------------------------------------------------------------------");
        System.out.println("       |       1. Show all product.                    |                 2. Create new product.             |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |       3. Update product.                      |                 4. Delete product.                 |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |       5. Search product by name.              |                 6. Exit.                           |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |                                      (Nhập lựa chọn của bạn)                                       |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
    }
    public static void navbarUserManager() {
        System.out.println("       *-------------------------------------------- ADMIN  ------------------------------------------------*");
        System.out.println("       ------------------------------------------------------------------------------------------------------");
        System.out.println("       |       1. Show list user.                      |                 2. Change status.                  |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |                                           3. Exit.                                                 |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |                                     (Nhập lựa chọn của bạn)                                        |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
    }
    // Admin

    // Customer
    public static  void navbarCustomer(){
        System.out.println("       *------------------------------------------- SHOP BÁN HÀNG ------------------------------------------*");
        System.out.println("       |                    *************** (GI GỈ GÌ GI CÁI GÌ CŨNG BÁN) ***************                   |");
        System.out.println("       ------------------------------------------------------------------------------------------------------");
        System.out.println("       |             1. Show all products.               |       2. Search product by category's name.      |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |             3. Search product by product's name.|       4. Cart.                                   |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |             5. Order Product.                    |      6. Feedback.                               |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |             7. Change information (password).   |       8. Log out.                                |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |                                       (Nhập lựa chọn của bạn)                                      |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
    }

    public  static  void navbarCart(){
        System.out.println("       *------------------------------------------- SHOP BÁN HÀNG ------------------------------------------*");
        System.out.println("       |                    *************** (GI GỈ GÌ GI CÁI GÌ CŨNG BÁN) ***************                   |");
        System.out.println("       ------------------------------------------------------------------------------------------------------");
        System.out.println("       |             1. Show may cart.                   |       2. Add product to cart.                    |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |             3. Change quantity.                 |       4. Delete item.                            |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |             5. Check Out.                        |      6. Exit.                                   |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |                                       (Nhập lựa chọn của bạn)                                      |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
    }
    // Customer

}