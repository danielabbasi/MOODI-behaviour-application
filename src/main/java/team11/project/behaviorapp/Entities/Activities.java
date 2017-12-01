package team11.project.behaviorapp.Entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "activities")
public class Activities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "activity_ID")
    public Long id;

    @Column(name = "activity_name")
    public String name;

    @Column(name = "activity_date")
    public Date activityDate;

    @Column(name="is_completed")
    public Boolean isCompleted;

    @Column(name="rating_before")
    public Long ratingBefore;

    @Column(name="rating_after")
    public Long ratingAfter;

    @Column(name="is_deleted")
    public Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "patient_id", insertable = false, updatable = false, referencedColumnName = "id")
    public Patient patients;

    public Activities(){

    }

    public Activities(Long id, String name, Date activityDate, Boolean isCompleted, Long ratingBefore, Long ratingAfter, Boolean isDeleted, Patient patients) {
        this.id = id;
        this.name = name;
        this.activityDate = activityDate;
        this.isCompleted = isCompleted;
        this.ratingBefore = ratingBefore;
        this.ratingAfter = ratingAfter;
        this.isDeleted = isDeleted;
        this.patients = patients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public Long getRatingBefore() {
        return ratingBefore;
    }

    public void setRatingBefore(Long ratingBefore) {
        this.ratingBefore = ratingBefore;
    }

    public Long getRatingAfter() {
        return ratingAfter;
    }

    public void setRatingAfter(Long ratingAfter) {
        this.ratingAfter = ratingAfter;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Patient getPatients() {
        return patients;
    }

    public void setPatients(Patient patients) {
        this.patients = patients;
    }
}

