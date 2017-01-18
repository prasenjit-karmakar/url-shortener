package com.infobip.urlshortener.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Prasenjit Karmakar
 */
@Path("/help")
public class ViewController {
    @GET
    public String getHelpPage() {
        return   new StringBuilder("Prerequisite: Java 8, Maven ").append("\n")
                .append("(1). Go to project directory ").append("\n")
                .append("(2). mvn clean compile install ").append("\n")
                .append("(3). java -jar target/urlMapping-shortener-1.0-SNAPSHOT.jar server src/main/resources/application_properties.yml ").append("\n")
                .append("(4). Opening of accounts: ").append("\n")
                .append(" curl -X POST -H \"Content-Type: application/json\" -H \"Cache-Control: no-cache\"  -d '{\n" +
                        "  \"AccountId\":\"3\"\n" +
                        "}' \"http://localhost:8080/account\" ").append("\n")
                .append("(5). Registering an url:").append("\n")
                .append("curl -X POST -H \"Content-Type: application/json\" -H \"Authorization: Basic Mzp2MmpHV3o5Ng==\" -H \"Cache-Control: no-cache\"  -d '{\n" +
                        "  \"url\":\"http://stackoverflow.com/questions/218384/what-is-a-nullpointerexception-and-how-do-i-fix-it\",\n" +
                        "  \"redirectType\": 301\n" +
                        "}' \"http://localhost:8080/register\"").append("\n")
                .append("(6). Statistics:").append("\n")
                .append("curl -X GET -H \"Content-Type: application/json\" -H \"Authorization: Basic Mzp2MmpHV3o5Ng==\" -H \"Cache-Control: no-cache\"  \"http://localhost:8080/statistic/2\"").append("\n")
                .append("(7). Click the short url to get redirected to actual url")
                .toString();
    }
}
