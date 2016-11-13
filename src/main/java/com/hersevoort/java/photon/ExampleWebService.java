package com.hersevoort.java.photon;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * @author Christian Hersevoort
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface ExampleWebService {

    @WebMethod
    String sayHi(String name);
}