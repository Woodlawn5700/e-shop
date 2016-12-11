package servlets;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * controller pages for user access or unlogged clients
 * Created by pavelpetrov on 01.11.16.
 */
@Controller
public class UserPageController {

    /**
     * method returns start page
     *
     * @return forward:/ProductListServlet
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomePage() {
        return "forward:/ProductListServlet";
    }

    /**
     * method returns index page
     *
     * @return index page
     */
    @RequestMapping(value = "/LoginUser", method = RequestMethod.GET)
    public String loginPage() {
        return "index";
    }


    /**
     * method returns MyCard page
     *
     * @return MyCard page
     */
    @RequestMapping(value = "/MyCartUser", method = RequestMethod.GET)
    public String myCartPage() {
        return "MyCard";
    }

    /**
     * method returns ProfileForm page
     *
     * @return ProfileForm page
     */
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = "/ProfileFormUser", method = RequestMethod.GET)
    public String profileFormPage() {
        return "ProfileForm";
    }

    /**
     * method returns ProductList page
     *
     * @return ProductList page
     */
    @RequestMapping(value = "/ProductListPage", method = RequestMethod.GET)
    public String productListPage() {
        return "ProductList";
    }

    /**
     * method returns Orders page
     *
     * @return Orders page
     */
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = "/OrderUserPage", method = RequestMethod.GET)
    public String orderUserPage() {
        return "Orders";
    }

    /**
     * method returns Registration page
     *
     * @return Registration page
     */
    @RequestMapping(value = "/RegustrationUserPage", method = RequestMethod.GET)
    public String regitrationUserPage() {
        return "Registration";
    }

    /**
     * method returns ChangeUserPassword page
     *
     * @return ChangeUserPassword page
     */
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = "/ChangeUserPasswordPage", method = RequestMethod.GET)
    public String changeUserPasswordPage() {
        return "ChangeUserPassword";
    }

    /**
     * method returns ChangeUserProfileInformation page
     *
     * @return ChangeUserProfileInformation page
     */
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = "/ChangeUserProfileInformationPage", method = RequestMethod.GET)
    public String changeUserProfileInformationPage() {
        return "ChangeUserProfileInformation";
    }

    /**
     * method returns ChangeUserProfileInformation errorPage
     *
     * @return errorPage page
     */
    @RequestMapping(value = "/ErrorPage", method = RequestMethod.GET)
    public String errorPage() {
        return "errorPage";
    }

    /**
     * method returns welcomeNewClient Page
     * @return welcomeNewClient Page
     */
    @RequestMapping(value = "/WelcomeNewClient", method = RequestMethod.GET)
    public String welcomeNewClient() {
        return "welcomeNewClient";
    }

}
