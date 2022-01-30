package com.example.springbootmvc.userDao;

import com.example.springbootmvc.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u",User.class).getResultList();
    }

    @Override
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        entityManager.remove(entityManager.merge(user));
    }

    @Override
    @Transactional
    public User findById(long id) {
        return entityManager.find(User.class,id);
    }
}
