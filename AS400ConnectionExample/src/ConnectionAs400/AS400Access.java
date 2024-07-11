package ConnectionAs400;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400SecurityException;
public class AS400Access { 
    public static AS400 createAS400Connection(String systemName, String userId, String password) throws AS400SecurityException {
        AS400 as400 = new AS400(systemName, userId, password);
        return as400;
    }
}
