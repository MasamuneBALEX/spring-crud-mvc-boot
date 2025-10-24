package com.spring.crud.boot.project.web_data.dao_classes;

import com.spring.crud.boot.project.web_data.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUserById(int id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        if (em.find(User.class, id) != null) {
            user = em.find(User.class, id);
        } else {
            throw new IllegalArgumentException("User with id " + id + " not found");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from users", User.class).getResultList();
    }
}
