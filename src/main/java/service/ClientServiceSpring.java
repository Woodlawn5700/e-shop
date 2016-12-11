package service;

import DAO.implementation.ClietnDaoImplSpring;
import DAO.implementation.RoleDaoImlSpring;
import DTO.ClientDTO;
import httphendler.HttpResult;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sessionscope.SessionScopeComponent;
import tables.Client;
import tables.Role;
import tables.TablesNames;

import java.util.ArrayList;
import java.util.List;

/**
 * CLass witch working with loginServlet
 * Created by pavelpetrov on 02.10.16.
 */
@Service
public class ClientServiceSpring {

    /**
     * inject ClietnDaoImplSpring spring bean
     */
    @Autowired
    private ClietnDaoImplSpring clientDao;

    /**
     * inject RoleDaoImplSpring spring bean
     */
    @Autowired
    private RoleDaoImlSpring roleDaoImlSpring;

    /**
     * inject GetProfitForDateSpring spring bean
     */
    @Autowired
    private GetProfitForDateSpring getProfitForDateSpring;

    /**
     * inject HttpResult spring bean
     */
    @Autowired
    private HttpResult registrationHttResult;

    /**
     * inject HashServiceSpring spring bean
     */
    @Autowired
    HashServiceSpring hashServiceSpring;

    /**
     * inject MailService spring bean
     */
    @Autowired
    private MailService mailService;

    /**
     * inject HttpResult spring bean
     */
    @Autowired
    private HttpResult result;

    /**
     * inject SessionScopeComponent spring bean
     */
    @Autowired
    private SessionScopeComponent sessionScopeComponent;


    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(ClientServiceSpring.class);


    /**
     * empty constructor
     */
    public ClientServiceSpring() {
    }


    /**
     * method checks client with two parameters
     *
     * @return client list
     */
    @Transactional
    public boolean loginClient(String login, String password) {

        boolean clientIsInTheList = true;
        if (clientDao.getAllObjectsFromeTableWithParamName
                (TablesNames.CLIENT, "login", "password", login, password).isEmpty()) {
            clientIsInTheList = false;
            logger.info("No such a client in DB");
        }
        return clientIsInTheList;
    }

    /**
     * method returns client with unique login
     *
     * @param login unique login of client
     * @return client with login
     */
    @Transactional
    public Client getClient(String login) {
        List<Client> clientList = (List<Client>) clientDao
                .getAllObjectsFromeTableWithParamName(TablesNames.CLIENT, "login", login);
        if (clientList.isEmpty()) {
            logger.info("Client List is NUll");
            if (logger.isDebugEnabled()) {
                logger.debug("Client List is NUll");
            }
            return null;
        } else {
            Client client = clientList.get(0);
            logger.info("Get Client");
            return client;
        }
    }

    /**
     * method returns client with unique login
     *
     * @param hashId unique hash of client
     * @return Client object
     */
    @Transactional
    public Client getClientHash(String hashId) {
        List<Client> clientList = (List<Client>) clientDao
                .getAllObjectsFromeTableWithParamName(TablesNames.CLIENT, "hashId", hashId);
        if (clientList.isEmpty()) {
            logger.info("Client List is NUll");
            if (logger.isDebugEnabled()) {
                logger.debug("Client List is NUll");
            }
            return null;
        } else {
            Client client = clientList.get(0);
            logger.info("Get Client");
            return client;
        }
    }

    /**
     * method update information in DB
     *
     * @param client updatable client
     */
    @Transactional
    public void updateClient(Client client) {
        clientDao.updateTable(client);
    }

    /**
     * method add new client to DB
     *
     * @param client new client
     */
    @Transactional
    public void addNewClientToDB(Client client) {
        Role role = roleDaoImlSpring.getObjectFromTable(1);
        client.setRole(role);
        clientDao.insertToTable(client);
    }


    /**
     * returns clients top list
     *
     * @return clientList
     */
    @Transactional
    public List<Client> getClientTopList() {
        return clientDao.getTopListOfObjects();
    }

    /**
     * returns get top orders of clients
     *
     * @return list Long
     */
    @Transactional
    public List<Long> getCount() {
        return clientDao.getTop();
    }

    /**
     * returns clientDTO list for webService
     *
     * @return clientDTO list
     */
    @Transactional
    public List<ClientDTO> getTopClientsDTOList() {
        List<Client> clients = clientDao.getTopListOfObjects();
        List<ClientDTO> clientDTOs = new ArrayList<>();
        for (Client client : clients) {
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setFirstName(client.getFirstName());
            clientDTO.setClientAddress(client.getClientAddress());
            clientDTO.setLogin(client.getLogin());
            clientDTO.setSecondName(client.getSecondName());
            clientDTOs.add(clientDTO);
        }
        logger.info("returned list of ClientDTO for WebService");
        return clientDTOs;
    }

    /**
     * method check client's password and login for webService
     *
     * @param login    client's login
     * @param password client's password
     * @return ClientDTO object
     */
    @Transactional
    public ClientDTO getLoginUserForWebService(String login, String password) {
        Client client = getClient(login);
        if (client != null && client.getPassword().equals(password)) {
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setRole(client.getRole().getRoleName());
            clientDTO.setLogin(client.getLogin());
            logger.info("returned client for webService");
            return clientDTO;
        } else {
            return null;
        }
    }

    /**
     * method returns profit between dates
     *
     * @param firstDate  first date for statistic
     * @param secondDate second date for statistic
     * @return profit
     */
    @Transactional
    public Long getProfitForWebService(String firstDate, String secondDate) {
        List<Long> longList = getProfitForDateSpring.getPrice(firstDate, secondDate);
        if (longList == null) {
            return null;
        } else {
            Long profit = longList.get(0);
            if (profit == null) {
                return null;
            } else {
                logger.info("returned profit for webService");
                return profit;
            }
        }
    }

    /**
     * nethod return true if registration completed
     *
     * @param hash unique client's hash
     * @return Boolean object
     */
    @Transactional
    public boolean completeRegistration(String hash) {
        Client client = getClientHash(hash);
        Boolean result = false;
        if (!client.isEnabled()) {
            client.setEnabled(true);
            updateClient(client);
            result = true;
        }
        return result;
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. method for registering new Client
     *
     * @param firstName     client's first name
     * @param lastName      client's last name
     * @param login         client's login
     * @param password      client's password
     * @param passwordAgain client's password again
     * @param clientAddress client's address
     * @return result to page
     */
    @Transactional
    public HttpResult registateNewClient(String firstName, String lastName, String login,
                                         String password, String passwordAgain, String clientAddress) {
        registrationHttResult.setMessage("");
        Client client = new Client();
        if (firstName.isEmpty() || lastName.isEmpty() || login.isEmpty() || password.isEmpty()
                || passwordAgain.isEmpty() || clientAddress.isEmpty()) {
            logger.info("Cannot be any empty fields in registration form");
            registrationHttResult.setMessage("Cannot be any empty fields in registration form");
        } else {
            if (!password.equals(passwordAgain)) {
                logger.info("Repeated password is Wrong");
                registrationHttResult.setMessage("Repeated password is Wrong");
            } else {
                if (getClient(login) != null) {
                    logger.info("Client with this login is already exist! Please choose another login");
                    registrationHttResult.setMessage("Client with this login is already exist! Please choose another login");
                } else {
                    if (!EmailValidator.getInstance().isValid(login)) {
                        logger.info("Client with this login is already exist! Please choose another login");
                        registrationHttResult.setMessage("Pleas check your Email Address!");
                    } else {
                        client.setFirstName(firstName);
                        client.setSecondName(lastName);
                        client.setLogin(login);
                        client.setPassword(password);
                        client.setClientAddress(clientAddress);
                        addNewClientToDB(client);
                        Client client1 = getClient(login);
                        String hash = hashServiceSpring.hashInformation(String.valueOf(client1.getEntityId()));
                        client.setHashId(hash);
                        updateClient(client);
                        mailService.completeRegistration(login, firstName, hash);
                        logger.info("Registration completed");
                        registrationHttResult.setData("Registration completed");
                    }
                }
            }

        }
        return registrationHttResult;
    }

    /**
     * Mthod change user password and update client information
     *
     * @param oldPas      old password
     * @param newPas      new password
     * @param newPasAgain new password again
     * @return HttpResult object
     */
    @Transactional
    public HttpResult changeUserPassword(String oldPas, String newPas, String newPasAgain) {
        Client client = sessionScopeComponent.getClient();
        result.setMessage("");
        if (!client.getPassword().equals(oldPas)) {
            result.setMessage("Wrong old Password!");
            logger.info("Wrong old Password!");
            if (logger.isDebugEnabled()) {
                logger.debug("Wrong old Password!");
            }
        } else {
            if (!newPas.equals(newPasAgain)) {
                result.setMessage("Repeated password is Wrong");
                logger.info("Repeated password is Wrong");
                if (logger.isDebugEnabled()) {
                    logger.debug("Repeated password is Wrong");
                }
            } else {
                client.setPassword(newPas);
                updateClient(client);
                result.setData("password changed");
                logger.info("password changed");
            }
        }
        return result;
    }

    /**
     * method get =params and update user profile
     *
     * @param firstName     first name
     * @param secondName    last name
     * @param clientAddress client's address
     * @param client        Client object
     */
    @Transactional
    public void changeCliemtsProfile(String firstName, String secondName, String clientAddress, Client client) {
        client.setFirstName(firstName);
        client.setSecondName(secondName);
        client.setClientAddress(clientAddress);
        updateClient(client);
        logger.info("information about client have been updated");
    }
}
