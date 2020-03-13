package ru.task.crudapponspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.task.crudapponspringboot.dao.UserDao;
import ru.task.crudapponspringboot.model.User;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

    private UserDao userDao;

    @Autowired
    public UserDetailServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = null;
        try {
            user = userDao.findUserByName(username);
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
}
