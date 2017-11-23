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

        @Column(name="is_deleted")
        public Boolean isDeleted;

        @Column(name = "rating")
        public Long rating;

    @ManyToOne
    @JoinColumn(name = "patient_id", insertable = false, updatable = false, referencedColumnName = "id")
    public Patient patients;

        public Activities(){

        }

        public Activities(Date activityDate, Long id, String name, Boolean isCompleted, Boolean isDeleted, Long rating, Patient patient) {
                this.name = name;
                this.isCompleted = isCompleted;
                this.isDeleted = isDeleted;
                this.rating = rating;
//                this.patient = patient;
                this.activityDate=activityDate;
                this.id = id;
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

        public Boolean getIsCompleted() {
                return isCompleted;
        }

        public void setIsCompleted(Boolean isCompleted) {
                this.isCompleted = isCompleted;
        }

        public Boolean getIsDeleted() {
                return isDeleted;
        }

        public void setIsDeleted(Boolean isDeleted) {
                this.isDeleted = isDeleted;
        }

        public Long getRating() {
                return rating;
        }

        public void setRating(Long rating) {
                this.rating = rating;
        }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }


    public Patient getPatients() {
        return patients;
    }

    public void setPatients(Patient patients) {
        this.patients = patients;
    }
}

