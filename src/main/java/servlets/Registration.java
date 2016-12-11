package servlets;

import httphendler.HttpResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ClientServiceSpring;

import javax.servlet.http.HttpServlet;

/**
 * Registration Servlet get parameters prom registration page ind with ClientService add new client to DB.
 * Created by pavelpetrov on 04.10.16.
 */
@Controller
public class Registration extends HttpServlet {
    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(Registration.class);

    /**
     * inject ClientServiceSpring spring bean
     */
    @Autowired
    private ClientServiceSpring clientServiceSpring;





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
    @RequestMapping(value = "/Registration", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult registration(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "seconName") String lastName,
            @RequestParam(value = "email") String login,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "password_confirm") String passwordAgain,
            @RequestParam(value = "clientAddress") String clientAddress
    ) {
        return clientServiceSpring.registateNewClient(firstName, lastName, login, password, passwordAgain, clientAddress);
    }


    @RequestMapping(value = "/CompleteRegistration", method = RequestMethod.GET)
        public String completeRegistration(
                @RequestParam(value = "hash") String hash) {
        Boolean result = clientServiceSpring.completeRegistration(hash);
        if (result) {
            return "forward:/WelcomeNewClient";
        }
        else return "redirect:/ErrorPage";
        }

}
