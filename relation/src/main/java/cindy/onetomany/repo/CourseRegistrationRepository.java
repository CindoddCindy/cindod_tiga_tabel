package cindy.onetomany.repo;

import java.util.Date;
import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;

import cindy.onetomany.model.CourseRegistration;

@Singleton
public class CourseRegistrationRepository implements CourseRegistrationInf{

    @PersistenceContext
    private EntityManager entityManager;

    public CourseRegistrationRepository(@CurrentSession EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Transactional(readOnly = true)
    @Override
    public List<CourseRegistration>findAll(int page, int limit){
        TypedQuery<CourseRegistration> query = entityManager.createQuery("from CourseRegistration", CourseRegistration.class)
        .setFirstResult(page > 1 ? page * limit - limit : 0).setMaxResult(limit);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Long save(@NotNull CourseRegistration courseRegistration){
        try{
            entityManager.persist(courseRegistration);
            return courseRegistration.getId();
        }catch (Exception e){
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public CourseRegistration findById(@NotNull Long Id){
        return entityManager.find(CourseRegistration.class,id);
    }

    @Transactional
    @Override 
    public boolean update(@NotNull Long id, String name, int phone){
        try{
            CourseRegistration courseRegistration = entityManager.find(CourseRegistration.class, id);
            if(name !=null) courseRegistration.setName(name);
            if(phone !=null) courseRegistration.setPhone(phone);
            courseRegistration.setUpdatedAt(new Date());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Transactional
    @Override
    public boolean destroy(@NotNull Long id){
        try{
            CourseRegistration courseRegistration = entityManager.find(CourseRegistration.class,id);
            entityManager.remove(courseRegistration);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}