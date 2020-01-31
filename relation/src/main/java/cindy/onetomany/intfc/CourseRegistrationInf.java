package cindy.onetomany.intfc;

import java.util.List;

import javax.validation.constraints.NotNull;

import cindod.onetomany.model.CourseRegistration;

public interface CourseRegistrationInf{
    List<CourseRegistration> findAll(int page, int limit);

    Long save(@NotNull CourseRegistration courseRegistration){
        Long size();

        Course findById(@NotNull Long id);
        boolean update(@NotNull Long id String name, int phone);
        boolean destroy(@NotNull Long id);
    }

}