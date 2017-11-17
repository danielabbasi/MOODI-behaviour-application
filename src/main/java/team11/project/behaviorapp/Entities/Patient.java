package team11.project.behaviorapp.Entities;

import javax.persistence.*;

/**
 * Created by c1673239 on 17/11/2017.
 */
@Entity
@Table(name = "patients")
public class Patient {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "nhs_number")
        public Long nhsid;


        @Column(name = "first_name")
        public String firstname;

        @Column(name = "last_name")
        public String lastname;

        @ManyToOne
        @JoinColumn(name = "gp_ID")
        GP gp;

        public Patient(){

        }

        public Patient(Long nhsid, String firstname, String lastname, GP gp) {
                this.nhsid = nhsid;
                this.firstname = firstname;
                this.lastname = lastname;
                this.gp = gp;
        }

        public Long getNhsid() {
                return nhsid;
        }

        public void setNhsid(Long nhsid) {
                this.nhsid = nhsid;
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


