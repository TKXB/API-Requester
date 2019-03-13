package com.yssec.sonarapi;

import com.yssec.util.RequestHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@PropertySource(value = {"classpath:sonarapi.properties"})
public class ProjectsSearch {
    @Value("${sonar.host}")
    private String host;

    @Value("${sonar.api.search}")
    private String api;

    @Value("${sonar.auth.basic}")
    private String auth;

    private String url;

    public RequestHandler requestHandler;

    public String getResult() throws Exception{
        url = host + api;
        Map headers = new HashMap();
        headers.put("Authorization", auth);
        requestHandler = new RequestHandler(url, "");
        requestHandler.setHeaders(headers);
        String result = requestHandler.postUrl();
        return result;
    }
}
