package cindy.onetomany.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "course")
public class Course extends GetMethods { 

    @OneToMany(mappedBy = "course")
    cascade= CascadeType.ALL
    orphanRemoval = true
    Set<CourseRegistration> courseRegistration;


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "insert course")
    @Column(name = "course_name")
    private String course_name;

    @NotNull(message = "insert student name")
    @Column(name = "student_name")
    private String student_name;

    @NotNull(message = " insert teacher name")
    @Column(name = "teacher_name")
    private teacher_name;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;

    @Column(name = " deleted_at", nullable = true)
    private Date deleted_at;

    public void setCourseRegistration(List<CourseRegistration> courseRegistration){
        this.courseRegistration=courseRegistration;

    }

    public List<CourseRegistration> getCourseRegistration(){
        return courseRegistration;
    }

    public void setCourseName(String course_name){
        this.course_name=course_name;
    }

    public String getCourseName(){
        return course_name;
    }

    public void setStudentName(String student_name){
        this.student_name=student_name;
    }

    public String getStudentName(){
        return student_name;
    }

    public void setTeacherName(String teacher_name){
        this.teacher_name=teacher_name;
    }

    public String getTeacherName(){
        return teacher_name;
    }

    public void getCreatedAt(Date created_at){
        this.created_at=created_at;
    }

    public Date getCreatedAt(){
        return created_at;
    }

    public void setUpdateAt(Date updated_at){
        this.updated_at=updated_at;
    }

    public Date getUpdateAt(){
        return updated_at;
    }

    public void setDeleted(Date deleted_at){
        this.deleted_at=deleted_at;
    }

    public Date getDeleteAt(){
        return deleted_at;
    }





}