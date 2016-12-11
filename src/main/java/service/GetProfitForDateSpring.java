package service;

import DAO.implementation.ProductDaoImplSpring;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * create statistic of profit for dates
 * Created by pavelpetrov on 24.10.16.
 */

@Service
public class GetProfitForDateSpring {
    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(GetProfitForDateSpring.class);

    /**
     * inject ProductDaoImplSpring spring bean
     */
    @Autowired
    ProductDaoImplSpring productDaoImplSpring;

    /**
     * Spring first date of profit select
     */
    private String firstDate;

    /**
     * String second date of profit select
     */
    private String secondDate;

    /**
     * firstdate getter
     * @return firstDate
     */
    public String getFirstDate() {
        return firstDate;
    }

    /**
     * first date setter
     * @param firstDate first date
     */
    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    /**
     * second date getter
     * @return secondDate
     */
    public String getSecondDate() {
        return secondDate;
    }

    /**
     * second date setter
     * @param secondDate second date
     */
    public void setSecondDate(String secondDate) {
        this.secondDate = secondDate;
    }

    /**
     * method returns dates in new format
     *
     * @param dateOne first param Date
     * @param dateTwo second param date
     */
    public void getToNewFormat(String dateOne, String dateTwo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(dateOne);
            Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(dateTwo);
            if (date1.before(date2)) {
                firstDate = new SimpleDateFormat("yyyy-MM-dd").format(date1);
                secondDate = new SimpleDateFormat("yyyy-MM-dd").format(date2);
                logger.info("first date befor second date");
            } else {
                secondDate = new SimpleDateFormat("yyyy-MM-dd").format(date1);
                firstDate = new SimpleDateFormat("yyyy-MM-dd").format(date2);
                logger.info("second date befor first date");
            }
        } catch (ParseException e) {
            logger.error("impossible dates");
            e.printStackTrace();
        }
    }

    /**
     * method return total price  for param period
     *
     * @param dateOne first date
     * @param datetwo last date
     * @return long list
     */
    @Transactional
    public List<Long> getPrice(String dateOne, String datetwo) {
        getToNewFormat(dateOne, datetwo);
        return productDaoImplSpring.getProfitByTime(firstDate, secondDate);
    }
}
