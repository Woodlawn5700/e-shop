package servlets;

import DTO.ClientDTO;
import DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.ClientServiceSpring;
import service.ProductListServiceSpring;

import java.util.List;

/**
 * controllers for WebService
 * Created by pavelpetrov on 15.11.16.
 */
@RestController
@RequestMapping("/service")
public class WebServiceController {

    /**
     * inject ClientServiceSpring spring bean
     */
    @Autowired
    private ClientServiceSpring clientServiceSpring;

    /**
     * inject ProductListServiceSpring spring bean
     */
    @Autowired
    private ProductListServiceSpring productListServiceSpring;

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. method returns ClientDTO top list
     *
     * @return ClientDTO top list
     */
    @RequestMapping(value = "/getClients", method = RequestMethod.GET)
    public ResponseEntity<List<ClientDTO>> getallClients() {
        List<ClientDTO> clients = clientServiceSpring.getTopClientsDTOList();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. return client DRO if client with this params in system
     *
     * @param login    client's login
     * @param password client's password
     * @return ClientDTO
     */
    @RequestMapping(value = "/loginClient", method = RequestMethod.GET)
    public ResponseEntity<ClientDTO> getUser(@RequestParam("login") String login,
                                             @RequestParam("password") String password) {
        return new ResponseEntity<>(clientServiceSpring.getLoginUserForWebService(login, password), HttpStatus.OK);
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. return number of orders of clients
     *
     * @return return number of orders of clients
     */
    @RequestMapping(value = "/nuberOfOrders", method = RequestMethod.GET)
    public ResponseEntity<List<Long>> getUser() {
        return new ResponseEntity<>(clientServiceSpring.getCount(), HttpStatus.OK);
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. returns Profit by param
     *
     * @param firstDate first date of selection
     * @param seconDate second date of selection
     * @return returns Profit by param
     */
    @RequestMapping(value = "/getProfit", method = RequestMethod.GET)
    public ResponseEntity<Long> getProfit(@RequestParam("firstDate") String firstDate,
                                          @RequestParam("secondDate") String seconDate) {
        return new ResponseEntity<>(clientServiceSpring.getProfitForWebService(firstDate, seconDate), HttpStatus.OK);
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. returns top 10 Product
     *
     * @return returns top 10 Product
     */
    @RequestMapping(value = "/getTopProducts", method = RequestMethod.GET)
    public ResponseEntity<List<ProductDTO>> getTopProducts() {
        return new ResponseEntity<>(productListServiceSpring.getTopProductsWebServiceApp(), HttpStatus.OK);
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. returns list of quantity of products witch was soled
     *
     * @return returns list of quantity of products witch was soled
     */
    @RequestMapping(value = "/getNumberOfProduct", method = RequestMethod.GET)
    public ResponseEntity<List<Long>> getProductNumber() {
        return new ResponseEntity<>(productListServiceSpring.getCountOfUniqueProductsInOrderTable(), HttpStatus.OK);
    }

}
