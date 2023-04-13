package rikkei.academy.view;

import rikkei.academy.Validate.Validate;
import rikkei.academy.config.Config;
import rikkei.academy.controller.ProductController;
import rikkei.academy.controller.UserController;
import rikkei.academy.model.*;

import java.util.List;



public class UserView {
    ProductController productController = new ProductController();
    UserController userController = new UserController();
    List<User> userList = userController.findAll();

    public User formLogin() {
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |                                                LOGIN                                               |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.print("       Enter username: ");
        String userName = Config.scanner().nextLine();
        System.out.print("       Enter password: ");
        String password = Config.scanner().nextLine();
        User user = userController.login(userName, password);
        return user;
    }

    public void formRegister() {
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        System.out.println("       |                                             REGISTER                                               |");
        System.out.println("       *----------------------------------------------------------------------------------------------------*");
        User newUser = new User();
        if (userList.size() == 0) {
            newUser.setId(1);
        } else {
            newUser.setId(userList.get(userList.size() - 1).getId() + 1);
        }
        System.out.print("       Enter username: ");
        while (true) {
            newUser.setUsername(Config.scanner().nextLine());
            if (userController.checkUsernameExists(newUser.getUsername())) {
                // tồn tại
                System.err.println("       Username is exist!!!");
            } else if (!Validate.checkUserName(newUser.getUsername())) {
                System.err.println("       User name 6 char!!!\n");
            } else {
                // chưa tồn tại
                break;
            }
        }
        System.out.print("       Enter full name: ");
        newUser.setFullName(Config.scanner().nextLine());
        System.out.print("       Enter password: ");
        while (true) {
            newUser.setPassword(Config.scanner().nextLine());
            if (!Validate.checkUserName(newUser.getPassword())) {
                System.err.print("       Password 6 characters\n");
            } else {

            }
            break;
        }
        newUser.setPassword(Config.scanner().nextLine());

        userController.create(newUser);
        System.out.println("       Create success!!!");
    }

    //Update password
    public void ChangeThePassword(User changePass) {
        while (true) {
            System.out.print("       Enter old password: ");
            String oldPassword = Config.scanner().nextLine();
            // Kiểm tra mật khẩu cũ
            if (!changePass.getPassword().equals(oldPassword)) {
                System.err.println("       Password does not match please re-enter!!!");
                continue;
            }
            System.out.print("       Enter new password: ");
            String newPassword = Config.scanner().nextLine();
            for (User u : userList) {
                if (u.getId() == changePass.getId()) {
                    u.setPassword(newPassword);
                    userController.update(u);
                    break;
                }
            }
            System.out.println("       Update password success!!!");
            break;
        }
    }
    //end update password


    public void showListUser() {
        for (User u : userList) {
            System.out.println(u);
        }
    }

    public void changeUserStatus() {
        System.out.print("       Enter id: ");
        int id = Config.scanner().nextInt();
        User user = userController.findById(id);
        if (user == null) {
            System.err.println("       Id not found!!!");
        } else {
            if (user.getRole() == RoleName.CUSTOMER) {
                userController.changeStatus(id);
                System.out.println("       Change status success.");
            } else {
                System.err.println("       You can't change Admin's status.");
            }
        }
    }

    public void showListCart(User user) {
        for (CartItem cartItem : user.getCart()) {
            System.out.println("       "+cartItem);
        }
    }

    public void addToCart(User user) {
        List<CartItem> cart = user.getCart();
        System.out.print("       Enter product id: ");
        int id = Config.scanner().nextInt();
        if (productController.searchProductById(id) == null) {
            System.err.print("       Id not found!!!");
        } else {
            Product product = productController.searchProductById(id);
            System.out.print("       Enter quantity: ");
            int quantity = Config.scanner().nextInt();
            int idNew = (cart.size() == 0) ? 1 : (cart.get(cart.size() - 1).getId() + 1);
            CartItem newCartItem = new CartItem(idNew, product, quantity);
            if (cart.size() == 0) {
                // giò hàng trống
                cart.add(newCartItem);
            } else {
                if (checkCartItemExists(cart, id)) {
//                    sản phẩm trùng
                    for (CartItem item : cart) {
                        if (item.getProduct().getProductId() == id) {
                            item.setQuantity(item.getQuantity() + quantity);
                            break;
                        }
                    }
                } else {
//                    sản phâm ko bị trùng
                    cart.add(newCartItem);
                }

            }
            System.out.println("       Add to cart success!!!");
            user.setCart(cart);
            userController.update(user);
        }
    }

    public boolean checkCartItemExists(List<CartItem> cart, int id) {
        for (CartItem item : cart) {
            if (item.getProduct().getProductId() == id) {
                return true;
            }
        }
        return false;
    }

    public void changeQuantityItem(User user) {
        List<CartItem> cart = user.getCart();
        System.out.print("       Enter cartItem id: ");
        int idCartItem = Config.scanner().nextInt();
        if (checkCartItemExits(cart, idCartItem)) {
            for (CartItem item : cart) {
                if (item.getId() == idCartItem) {
                    System.out.print("       Enter new quantity , old quantity is: " + item.getQuantity());
                    item.setQuantity(Config.scanner().nextInt());
                    user.setCart(cart);
                    userController.update(user);
                    System.out.println("       Update success!!! ");
                    break;
                }
            }
        } else {
            System.err.println("       Id not found in cart!!!");
        }

    }

    public void deleteCartItem(User user) {
        List<CartItem> cart = user.getCart();
        System.out.print("       Enter cartItem id: ");
        int idCartItem = Config.scanner().nextInt();
        if (checkCartItemExits(cart, idCartItem)) {
            for (CartItem item : cart) {
                if (item.getId() == idCartItem) {
                    // xoá nó
                    cart.remove(item);
                    user.setCart(cart);
                    userController.update(user);
                    break;
                }
            }
        } else {
            System.err.println("       Id not found in cart!!!");
        }
    }

    public boolean checkCartItemExits(List<CartItem> cart, int idCartItem) {
        for (CartItem item : cart) {
            if (item.getId() == idCartItem) {
                return true;
            }
        }
        return false;
    }
}
