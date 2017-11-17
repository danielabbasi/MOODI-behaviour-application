package team11.project.behaviorapp.Entities;
import javax.persistence.*;

/**
 * Created by c1673239 on 17/11/2017.
 */
@Entity
@Table(name = "gps")
public class GP {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "gp_ID")
        public Long id;

        @Column(name = "first_name")
        public String name;

        @Column(name = "last_name")
        public String surname;

        public GP(){

        }

        public GP(Long id, String name, String surname) {
                this.name = name;
                this.surname = surname;
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

        public String getSurname() {
                return surname;
        }

        public void setSurname(String surname) {
                this.surname = surname;
        }
}



