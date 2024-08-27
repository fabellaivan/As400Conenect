package com.ivano.prueba.ConnectionAs400;

import com.ibm.as400.access.AS400;

public class AS400Access {

    public static  AS400 createAS400Connection(String systemName, String userId, String password)  {

        char[] passwordCharArray = password.toCharArray();
        return new AS400(systemName, userId, "suenios$3");
    }
}
