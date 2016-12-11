package tables;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Hiberanate class discolate entity of "Client" table in DB
 * Created by pavelpetrov on 27.09.16.
 */

@Entity
@Table(name = "client")
@AttributeOverride(name = "entityId", column = @Column(name = "client_id"))
public class Client extends TableEntity {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(Client.class);

    /**
     * first name of client
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * second name of client
     */
    @Column(name = "cecond_name")
    private String secondName;

    /**
     * client's address
     */
    @Column(name = "client_address")
    private String clientAddress;

    /**
     * client's login/ his eMail
     */
    @Column(name = "login", unique = true)
    private String login;

    /**
     * client's passwod
     */
    @Column(name = "password")
    private String password;

    /**
     * clietn's hash id
     */
    @Column(name = "hashCl")
    private String hashId;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "enabled", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean enabled;

    /**
     * set of orderses
     */
    @OneToMany(mappedBy = "client")
    private Set<Orders> orderses = new HashSet<Orders>();

    /**
     * default constructor
     */
    public Client() {
    }

    public Client(String firstName, String secondName, String clientAddress, String login) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.clientAddress = clientAddress;
        this.login = login;
    }

    /**
     * Role getter
     *
     * @return Role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Role setter
     *
     * @param role Role object
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * client's first name getter
     *
     * @return String client's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * client's first name setter
     *
     * @param firstName String client's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * second name getter
     *
     * @return String client's second name
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * second name setter
     *
     * @param secondName String client's second name
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * client's address getter
     *
     * @return String client's address
     */
    public String getClientAddress() {
        return clientAddress;
    }

    /**
     * client's address setter
     *
     * @param clientAddress client's address
     */
    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    /**
     * client's login getter
     *
     * @return String client's login
     */
    public String getLogin() {
        return login;
    }

    /**
     * client's login setter
     *
     * @param login client's login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * client's password getter
     *
     * @return String client's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * client's password setter
     *
     * @param password String client's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Orders Set getter
     *
     * @return Set of Orders objects
     */
    public Set<Orders> getOrderses() {
        return orderses;
    }

    /**
     * Orders Set setter
     *
     * @param orderses Set of Orders objects
     */
    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }

    /**
     * enamble status getter
     *
     * @return enamble status
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * enamble status setter
     *
     * @param enabled enamble status
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * client's hash getter
     * @return String Hash id
     */
    public String getHashId() {
        return hashId;
    }

    /**
     * client's hash setter
     * @param hashId String Hash id
     */
    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    /**
     * override toString for Client
     *
     * @return String toString
     */
    @Override
    public String toString() {
        return "Client is" + getFirstName() + "\t" + getLogin();
    }
}
