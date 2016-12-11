package DTO;

/**
 * Client DTO class
 * Created by pavelpetrov on 15.11.16.
 */
public class ClientDTO {
    /**
     * client's first name
     */
    private String firstName;

    /**
     * client's second Name
     */
    private String secondName;

    /**
     * client's adress
     */
    private String clientAddress;

    /**
     * client's login
     */
    private String login;

    /**
     * client's role
     */
    private String role;

    /**
     * role getter
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * role setter
     * @param role client's role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * first name getter
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * first name setter
     * @param firstName clinet's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * second name getter
     * @return secondName
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * second Name setter
     * @param secondName second Name
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * client address getter
     * @return clientAddress
     */
    public String getClientAddress() {
        return clientAddress;
    }

    /**
     * client address setter
     * @param clientAddress client address
     */
    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    /**
     * login getter
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * login setter
     * @param login client's login
     */
    public void setLogin(String login) {
        this.login = login;
    }

}
