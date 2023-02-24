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
     public  static boolean addOrUpdate(final Operations operations, final BaseEntity object){
      boolean flag = false;

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
     
      try { //try with resource всегда должен имплиментироваться от autoclosable
            transaction = manager.getTransaction();
            transaction.begin();
            if(operations.equals(Operations.CREATE)){
                manager.persist(object);
            }else{
                manager.merge(object);
            }

            transaction.commit();
            flag = true;//проверка что update или user прошла успешно

        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();

        }finally {
            manager.close();
        }
      return flag;


     }

 public static List<Post> getAllBlog() {
  List<Post> blogs = new ArrayList();


            EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
            EntityTransaction transaction = null;
 try{}catch()finally{}
 }
  

   
}
