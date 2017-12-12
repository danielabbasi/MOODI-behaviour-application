package team11.project.behaviorapp.Repositories;

import java.time.LocalDateTime;

/**
 * Created by c1673239 on 11/12/2017.
 */

public interface deletionList {
    String getName();
    LocalDateTime getActivityDate();
    Integer getRatingBefore();
    Integer getRatingAfter();
    //boolean getIsDeleted();
}
