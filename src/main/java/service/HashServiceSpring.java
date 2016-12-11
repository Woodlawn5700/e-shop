package service;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * service warks with hashing information
 * Created by pavelpetrov on 21.11.16.
 */
@Service
public class HashServiceSpring {
    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(HashServiceSpring.class);

    // Define the BCrypt WORKLOAD to use when generating password hashes. 10-31 is a valid value.
    private static int WORKLOAD = 12;


    /**
     *  This method can be used to generate a string representing an account password
     * suitable for storing in a database.
     * @param textForHashing text for hashing
     * @return String - a string of length 60 that is the bcrypt hashed password in crypt(3) format.
     */
    public  String hashInformation(String textForHashing) {
        String salt = BCrypt.gensalt(WORKLOAD);
        return(BCrypt.hashpw(textForHashing, salt));
    }

    /**
     *
     * @param textForHashing new hash just maiden from last method
     * @param stored_hash hash in DB
     * @return boolean - true if the password matches the password of the stored hash, false otherwise
     */
    public  boolean checkPassword(String textForHashing, String stored_hash) {
        boolean password_verified = false;
        if(null == stored_hash || !stored_hash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        password_verified = org.mindrot.jbcrypt.BCrypt.checkpw(textForHashing, stored_hash);
        logger.info("");
        return(password_verified);
    }
}
