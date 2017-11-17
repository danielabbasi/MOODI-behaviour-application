package team11.project.behaviorapp.Entities;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;

/**
 * Created by c1673239 on 17/11/2017.
 */
@Entity
@Table(name = "activities")
public class Activities {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "activity_ID")
        private Long id;

        @Column(name = "activity_name")
        private String name;

        @Column(name="is_completed")
        private Boolean iscompleted;

        @Column(name="is_deleted")
        private Boolean isdeleted;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "nhsnumber")
        private Long nhsid;

        @Column(name = "rating")
        private Integer rating;



    }

