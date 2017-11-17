package team11.project.behaviorapp.Entities;

import com.sun.org.apache.xpath.internal.operations.Bool;

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
        public Boolean iscompleted;

        @Column(name="is_deleted")
        public Boolean isdeleted;

        @Column(name = "rating")
        public Long rating;

    @ManyToOne
    @JoinColumn(name = "patient_id", insertable = false, updatable = false, referencedColumnName = "id")
    public Patient patients;

        public Activities(){

        }

        public Activities(Date activityDate, Long id, String name, Boolean iscompleted, Boolean isdeleted, Long rating, Patient patient) {
                this.name = name;
                this.iscompleted = iscompleted;
                this.isdeleted = isdeleted;
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

        public Boolean getIscompleted() {
                return iscompleted;
        }

        public void setIscompleted(Boolean iscompleted) {
                this.iscompleted = iscompleted;
        }

        public Boolean getIsdeleted() {
                return isdeleted;
        }

        public void setIsdeleted(Boolean isdeleted) {
                this.isdeleted = isdeleted;
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

