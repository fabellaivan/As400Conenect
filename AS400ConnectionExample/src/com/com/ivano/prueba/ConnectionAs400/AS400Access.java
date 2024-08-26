package com.ivano.prueba.ConnectionAs400;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400SecurityException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class AS400Access {
    @Contract("_, _, _ -> new")
    public static @NotNull AS400 createAS400Connection(String systemName, String userId, @NotNull String password) throws AS400SecurityException {

        char[] passwordCharArray = password.toCharArray();
        return new AS400(systemName, userId, passwordCharArray);
    }
}
