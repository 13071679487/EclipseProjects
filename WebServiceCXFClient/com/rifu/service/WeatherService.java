package com.rifu.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-05-01T11:50:20.417+08:00
 * Generated source version: 3.2.4
 *
 */
@WebService(targetNamespace = "http://service.rifu.com/", name = "WeatherService")
@XmlSeeAlso({ObjectFactory.class})
public interface WeatherService {

    @WebMethod
    @RequestWrapper(localName = "getWeatherByCity", targetNamespace = "http://service.rifu.com/", className = "com.rifu.service.GetWeatherByCity")
    @ResponseWrapper(localName = "getWeatherByCityResponse", targetNamespace = "http://service.rifu.com/", className = "com.rifu.service.GetWeatherByCityResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String getWeatherByCity(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
