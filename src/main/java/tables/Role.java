package tables;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**\
 *  Hiberanate class discolate entity of "role" table in DB
 * Created by pavelpetrov on 07.11.16.
 */
@Entity
@Table(name = "role")
@AttributeOverride(name = "entityId", column = @Column(name = "role_id"))
public class Role extends TableEntity {
    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(Role.class);

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role")
    private Set<Client> clients = new HashSet<Client>();

    /**
     * Clients Set getter
     *
     * @return Clients Set
     */
    public Set<Client> getClients() {
        return clients;
    }

    /**
     * Clients Set  setter
     *
     * @param clients Clients Set
     */
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    /**
     * role name getter
     *
     * @return String role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * role name setter
     *
     * @param roleName String role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
