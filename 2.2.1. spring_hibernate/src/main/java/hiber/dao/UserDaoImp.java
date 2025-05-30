package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public void deleteUsers() {
      sessionFactory.getCurrentSession().createQuery("DELETE FROM User").executeUpdate();
   }

   public User getUserByCar(int series, String model) {
      Query query = sessionFactory.getCurrentSession()
              .createQuery("from User where car.series=:series and car.model=:model");
      query.setParameter("series", series);
      query.setParameter("model", model);
      User user = (User) query.getSingleResult();
      return user;
   }
}
