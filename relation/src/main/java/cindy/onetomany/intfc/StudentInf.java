package cindy.onetomany.intfc;

import java.util.List;

import javax.validation.constraints.NotNull;

import steamdom.master.model.Course;

public interface StudentInf{

    List<Student> findAll(int page, int limit);

    Long save(@NotNull Student student);

    Long size();

    Student findById(@NotNull Long id);

    boolean update(@NotNull Long id, String student_name);

    boolean destroy(@NotNull Long id);



}