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
 * servlet request params for changing user password and write to the DB
 * Created by pavelpetrov on 16.10.16.
 */
@Controller
public class ChangeUserPassword extends HttpServlet {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(ChangeUserPassword.class);

    /**
     * inject HttpResult spring bean
     */
    @Autowired
    private HttpResult result;

    /**
     * inject ClientServiceSpring spring bean
     */
    @Autowired
    private ClientServiceSpring clientServiceSpring;



    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. method change ald password to new.
     *
     * @param oldPas      old password
     * @param newPas      new password
     * @param newPasAgain new password again
     * @return HttpResult
     */
    @RequestMapping(value = "/ChangeUserPassword", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult changeUserPassword(
            @RequestParam(value = "oldPas") String oldPas,
            @RequestParam(value = "newPas") String newPas,
            @RequestParam(value = "newPasAgain") String newPasAgain
    ) {
       return clientServiceSpring.changeUserPassword(oldPas, newPas, newPasAgain);
    }
}
