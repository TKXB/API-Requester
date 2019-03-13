package com.yssec.sonarapi;

import com.yssec.util.RequestHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@PropertySource(value = {"classpath:sonarapi.properties"})
public class NewIssue {
    @Value("${sonar.host}")
    private String host;

    @Value("${sonar.api.issues.search}")
    private String api;

    @Value("${sonar.auth.basic}")
    private String auth;

    private String url;

    public RequestHandler requestHandler;

    public String getResult() throws Exception{
        url = host + api;
        Map headers = new HashMap();
        headers.put("Authorization", auth);
        requestHandler = new RequestHandler(url, "ps=500");
        requestHandler.setHeaders(headers);
        String result = requestHandler.getUrl();
        return result;
    }
}
