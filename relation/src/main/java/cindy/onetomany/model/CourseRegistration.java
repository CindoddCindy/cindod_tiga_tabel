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
@Table(name = "courseregistration")
public class CourseRegistration{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTYTY)
    private Long id;

    @ManyToOne(optiona = false)
    @JoinColumn(name= "student_id", referencedColumnName = "id", insertable=true, updateable=true)
     private Student student;
     private Long student_id;

    @ManyToOne
    @JoinColumn(name = "course_id",referencedColumnName = "id", insertable=false, updateable = false)
    private Course course;
    private Long course_id;

    @NotNull(message = "insert name ")
    @Column(name = "name")
    private String name;

    @NotNull(message = "insert phone")
    @Column(name = "phone")
    private int phone;

   

    public void setStudent(Student student){
        this.student=student;
    }

    public Student getStudent(){
        return student;
    }

    public void setCourse(Course  course){
        this.course=course;
    }

    public Course getCourse(){
        return course;
    }

    public void setCreate(Date created_at){
        this.created_at=created_at;
    }

    public Date getCreatedDate(){
        created_at;
    }

    public Date setUpdate(Date updated_at){
        this.updated_at=updated_at;
    }

    public Date getUpdate(){
        return updated_at;
    }

    public void setDeleted(Date deleted_at){
        this.deleted_at=deleted_at;
    }

    public Date getDeleted(){
        return deleted_at;
    }


    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setPhone(int phone){
        this.phone=phone;
    }

    public int getPhone(){
        return phone;
    }
}