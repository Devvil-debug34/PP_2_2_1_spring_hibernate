package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);

   List<User> listUsers();

   void deleteUsers();

   User getUserByCar(int series, String model);
}
