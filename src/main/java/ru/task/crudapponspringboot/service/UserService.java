package ru.task.crudapponspringboot.service;

import ru.task.crudapponspringboot.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    void saveOrUpdate(User user);

    User findUserByName(String name);

    void deleteById(Long id);
}
