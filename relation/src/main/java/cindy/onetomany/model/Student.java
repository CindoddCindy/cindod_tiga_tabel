public class Student{
    
    @OneToMany(mappedBy = "student")
    Set<CourseRegistration> courseRegistration;
    
}