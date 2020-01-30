
package steamdom.master.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GenerationType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;




public class Student{
    
    @OneToMany(mappedBy = "student")
    cascade= CascadeType.ALL
    orphanRemoval = true
    Set<CourseRegistration> courseRegistration;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "insert student name ")
    @Column(name = "student_name")
    private String student_name;

    @NotNull(message = "insert student address")
    @Column(name = "student_address")
    private String student_address;

    @NotNull(message = " insert Student phone number")
    @Column(name = " student_phone_number")
    private Long  student_phone_number;

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


    public void setStudentName(String student_name)
    {
        this.student_name=student_name;
    } 

    public String getStudentName(){
        return student_name;
    }

    public void setStudentAddress(String student_address){
        this.student_address=student_address;
    }

    public String getStudentAddress(){
        return student_address;
    }

    public void setStudentPhone(Long student_phone_number){
        this.student_phone_number=student_phone_number;
    }

    public Long getStudentPhone(){
        return student_phone_number;
    }

    public void setCreatedAt(Date created_at){
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

    public void setDeletedAt(Date deleted_at){

        this.deleted_at=deleted_at;
    }

    public Date getDeletedAt(){
        return deleted_at;
    }


    
    

}