package team11.project.behaviorapp.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by c1673239 on 17/11/2017.
 */
@Entity
@Table(name = "patients")
public class Patient {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        public Long id;

        @Column(name = "nhs_number")
        public Long nhsnumber;

        @Column(name = "first_name")
        public String firstname;

        @Column(name = "last_name")
        public String lastname;

        @ManyToOne
        @JoinColumn(name = "gp_ID")
        public GP gp;

        @OneToMany(mappedBy = "patients")
        List<Activities> activities;

        public Patient(){

        }

        public Patient(Long id, Long nhsnumber, String firstname, String lastname, GP gp) {
                this.id = id;
                this.nhsnumber = nhsnumber;
                this.firstname = firstname;
                this.lastname = lastname;
                this.gp = gp;
        }

        public Long getID() {
                return id;
        }

        public void setID(Long id) {
                this.id = id;
        }

        public Long getNhsnumber() {
                return nhsnumber;
        }

        public void setNhsnumber(Long nhsnumber) {
                this.nhsnumber = nhsnumber;
        }

        public String getFirstname() {
                return firstname;
        }

        public void setFirstname(String firstname) {
                this.firstname = firstname;
        }

        public String getLastname() {
                return lastname;
        }

        public void setLastname(String lastname) {
                this.lastname = lastname;
        }

        public GP getGp() {
                return gp;
        }

        public void setGp(GP gp) {
                this.gp = gp;
        }
}


