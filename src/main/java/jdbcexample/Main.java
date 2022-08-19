package jdbcexample;


import jdbcexample.manager.UserManager;
import jdbcexample.model.User;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserManager userManager = new UserManager();

        User user = new User("poxos", "poxosyan", "poxos@mail.ru", "poxos99");
        userManager.addUser(user);
        System.out.println(user);

        List<User> allUser = userManager.getAllUser();
        for (User user1 : allUser) {
            System.out.println(user1);
        }

        userManager.deleteUserById(2);
    }
}
