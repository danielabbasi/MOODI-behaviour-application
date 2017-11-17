package team11.project.behaviorapp.Entities;

import javax.persistence.*;

/**
 * Created by c1673239 on 17/11/2017.
 */
public class Patient {
    @Entity
    @Table(name = "patients")
    public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "nhsnumber")
        private Long nhsid;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "gp_ID")
        private Long id;


        @Column(name = "first_name")
        private String firstname;

        @Column(name = "last_name")
        private String lastname;
    }
}
