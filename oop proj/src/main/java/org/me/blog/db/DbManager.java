package org.me.blog.db;


import org.me.blog.entity.BaseEntity;
import org.me.blog.entity.Post;
import org.me.blog.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class DbManager {

 
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("default");


    public static User getUserByEmail(final String email){

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;


        User user = null;

        try { //try with resource всегда должен имплиментироваться от autoclosable
            transaction = manager.getTransaction();

            transaction.begin();
            Query query = manager.createQuery("from User u where u.email= : email");//пишется не на sql, пишется на hql или jpql
            user = (User)query.setParameter("email", email).getSingleResult();
            transaction.commit();

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();

        } finally {
            manager.close();
        }
        return user;
    }

  

   
}
