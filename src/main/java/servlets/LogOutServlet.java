package servlets;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

/**
 * LogOut servlet log out user from the system
 * Created by pavelpetrov on 15.10.16.
 */
@Controller
public class LogOutServlet extends HttpServlet {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(LogOutServlet.class);

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments.method for log out.
     * @param session HttpSession
     * @return redirect to ProductListServlet
     */
    @RequestMapping(value = "/LogOutSetrvlet", method = RequestMethod.GET)
    public String logOut(HttpSession session) {
        session.invalidate();
        logger.info("Client logged out");
        return "forward:/ProductListServlet";
    }
}
