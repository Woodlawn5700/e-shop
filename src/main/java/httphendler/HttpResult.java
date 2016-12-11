package httphendler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * class container of JSON response from servlet to Jquery
 * Created by pavelpetrov on 17.10.16.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HttpResult {
    /**
     * class Logger
     */
    private static Logger logger = Logger.getLogger(HttpResult.class);

    /**
     * private message of some error
     */
    private String message;

    /**
     * Boolean success.
     * if success is true - everything is ok,
     * else Jquery reads message
     */
    private Boolean success;

    /**
     * data may contains any object what we want to send to Jquery
     */
    private Object data;

    /**
     * constructor
     *
     * @param message message
     * @param success boolean indicator
     * @param data    object file
     */
    public HttpResult(String message, Boolean success, Object data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

    /**
     * empty constructor
     */
    public HttpResult() {
        this.message = "";
        this.success = false;
    }

    public String getMessage() {
        return message;
    }

    /**
     * if set message it's means that on server some error and you want to send error message to client
     *
     * @param message error message
     */
    public void setMessage(String message) {
        this.message = message;
        this.success = false;
        logger.info("Create new message for Client");
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    /**
     * if set data it's means that everything is ok, and you want to send some object to client
     *
     * @param data object to send
     */
    public void setData(Object data) {
        this.data = data;
        this.success = true;
        logger.info("Set data for Gson Object from servlet to client Page");
    }
}

