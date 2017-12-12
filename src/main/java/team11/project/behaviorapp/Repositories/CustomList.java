package team11.project.behaviorapp.Repositories;

import java.time.LocalDateTime;

/**
 * Created by c1673218 on 17/11/2017.
 */
public interface CustomList {
    String getName();
    LocalDateTime getActivityDate();
    Integer getRatingBefore();
    Integer getRatingAfter();
    //boolean getIsDeleted();
}
