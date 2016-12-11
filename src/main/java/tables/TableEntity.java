package tables;


import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Abstract table entity class
 * Created by pavelpetrov on 30.09.16.
 */

@MappedSuperclass
public abstract class TableEntity implements Serializable {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(TableEntity.class);

    /**
     * id of abstract class
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int entityId;

    /**
     * eintity id getter
     *
     * @return int entity id
     */
    public int getEntityId() {
        return entityId;
    }

    /**
     * eintity id setter
     *
     * @param projectTableEntatyId int entity id
     */
    public void setEntityId(int projectTableEntatyId) {
        this.entityId = projectTableEntatyId;
    }
}
