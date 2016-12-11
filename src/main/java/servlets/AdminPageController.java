package servlets;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * controller for admin pages
 * Created by pavelpetrov on 06.11.16.
 */
@Controller
public class AdminPageController {

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. Method return StatisticAdmin page
     *
     * @return StatisticAdmin page
     */
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/StatisticAdminPage", method = RequestMethod.GET)
    public String statisticAdminPage() {
        return "StatisticAdmin";
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. Method return ProductRegistrationAdmin  page
     *
     * @return ProductRegistrationAdmin
     */
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/ProductRegistrationPageAdmin", method = RequestMethod.GET)
    public String productRegistrationPageAdmin() {
        return "ProductRegitrationAdmin";
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. Method return OrderListAdmin  page
     *
     * @return OrderListAdmin page
     */
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/OrderListAdminPage", method = RequestMethod.GET)
    public String orderListAdminPage() {
        return "OrderListAdmin";
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. Method return OrderChangeInfromationAdmin page
     *
     * @return OrderChangeInfromationAdmin page
     */
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/OrderChangeInfromationAdminPage", method = RequestMethod.GET)
    public String orderChangeInfromationAdminPage() {
        return "OrderChangeInfromationAdmin";
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. Method return CreateNewCategoryAdmin page
     *
     * @return CreateNewCategoryAdmin page
     */
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/CreateNewCategoryAdminPage", method = RequestMethod.GET)
    public String createNewCategoryAdminPAge() {
        return "CreateNewCategoryAdmin";
    }

}
