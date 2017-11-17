package team11.project.behaviorapp.Entities;
import javax.persistence.*;

/**
 * Created by c1673239 on 17/11/2017.
 */
public class GP {
    @Entity
    @Table(name = "gps")
    public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "gpID")
        private Long id;

        @Column(name = "first_name")
        private String name;

        @Column(name = "last_name")
        private String surname;
    }

}
