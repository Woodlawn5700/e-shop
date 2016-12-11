package servlets;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ClientServiceSpring;
import tables.Client;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

/**
 * servlet update client information in DB
 * Created by pavelpetrov on 15.10.16.
 */
@Controller
public class ChangeUserProfile extends HttpServlet {
    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(ChangeUserProfile.class);

    /**
     * inject ClientServiceSpring spring bean
     */
    @Autowired
    private ClientServiceSpring clientServiceSpring;

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. Method change profile of client
     *
     * @param firstName     first name to change
     * @param secondName    second name to change
     * @param clientAddress client address to change
     * @param request       HttpSession
     * @return redirect to ProfileFormUser controller
     */
    @RequestMapping(value = "/ChangeUserProfile", method = RequestMethod.POST)
    public String changeUserProfile(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "secondName") String secondName,
            @RequestParam(value = "clientAddress") String clientAddress,
            HttpSession request
    ) {

        Client client = (Client) request.getAttribute("client");
        clientServiceSpring.changeCliemtsProfile(firstName, secondName, clientAddress, client);
        return "redirect:/ProfileFormUser";
    }
}
