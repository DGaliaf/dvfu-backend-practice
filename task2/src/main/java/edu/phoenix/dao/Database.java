package edu.phoenix.dao;

import edu.phoenix.exception.EmptyArrayException;
import edu.phoenix.exception.UserDuplicateException;
import edu.phoenix.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Database {
  public static List<User> dataBase = new ArrayList<>();

  public static void addUser(String name, String login, String password) {
    User user = new User(name, login, password);

    try {
      if (dataBase.contains(user)) {
        throw new UserDuplicateException();
      }

      dataBase.add(user);
    } catch (UserDuplicateException e) {
      e.printStackTrace();
    }
  }

  public static User getUser(String login, String password) {
    for (User user : dataBase) {
      if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
        return user;
      }
    }

    return new User("", "", "");
  }

  public static void deleteUser(String login) {
    try {
      if (dataBase.size() <= 0) {
        throw new EmptyArrayException();
      }
    } catch (EmptyArrayException e) {
      e.printStackTrace();
    }

    dataBase.removeIf(user -> user.getLogin().equals(login));
  }

  public static void updateUser(User user) {
    for (int i = 0; i < dataBase.size(); i++) {
      if (dataBase.get(i).getLogin().equals(user.getLogin())) {
        dataBase.remove(i);
        dataBase.add(i, user);
      }
    }
  }

}
