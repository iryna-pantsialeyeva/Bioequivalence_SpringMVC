package by.freeit.repository;

import by.freeit.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public abstract class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactoryBean;
    private static final String hql = "from User U where U.userName = :username";

    public User loadUserByName(String username) {
        Session session = sessionFactoryBean.getCurrentSession();
        Query userQuery = session.createQuery(hql);
        userQuery.setParameter("username", username);
        return (User) userQuery.getSingleResult();
    }
}
