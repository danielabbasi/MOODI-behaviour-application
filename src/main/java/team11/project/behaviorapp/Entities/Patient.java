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
        private Long nhsid;


        @Column(name = "first_name")
        private String firstname;

        @Column(name = "last_name")
        private String lastname;

        @ManyToOne
        @JoinColumn(name = "gp_ID")
        GP gp;
    }

