package team11.project.behaviorapp.Entities;

import javax.persistence.Entity;

/**
 * Created by c1443907 on 04/12/2017.
 */

public class abc {


    public Integer count;


    public  abc(){

    }
    public abc (Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
