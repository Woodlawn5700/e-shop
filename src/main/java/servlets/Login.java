package servlets;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ClientServiceSpring;
import service.OrderSelectServiceSpring;
import sessionscope.SessionScopeComponent;
import tables.Client;
import tables.Orders;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * servlet realised login structure
 * Created by pavelpetrov on 02.10.16.
 */
@Controller
public class Login {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(Login.class);

    /**
     * inject ClientServiceSpring spring bean
     */
    @Autowired
    private ClientServiceSpring clientServiceSpring;

    /**
     * inject OrderSelectServiceSpring spring
     */
    @Autowired
    private OrderSelectServiceSpring orderSelectServlet;


    /**
     * inject SessionScopeComponent spring bean
     */
    @Autowired
    private SessionScopeComponent sessionScopeComponent;

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. logging checking witj framwork spring security on index page
     *
     * @param model  springframework model
     * @param error  spring security error
     * @param logout spring security logout
     * @return index page
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
            logger.info("Your username and password is invalid.");
        }
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "index";
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. Method create session attributes for authorised client
     *
     * @param session HttpSession
     * @return redirect to start controller
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String login(
            HttpSession session) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        String username = userDetails.getUsername();
        List<Orders> ordersListByName = orderSelectServlet.getListOfOrderByClient(username);
        Client client = clientServiceSpring.getClient(username);
        sessionScopeComponent.setClient(client);
        sessionScopeComponent.setUsername(username);
        session.setAttribute("username", username);
        session.setAttribute("client", client);
        session.setAttribute("orderListByClientName", ordersListByName);
        logger.info("client have been authorised to system");
        return "redirect:/";
    }
}
