package com.yssec.sonarapi;

import com.yssec.util.RequestHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:sonarapi.properties"})
public class SonarAuth {
    @Value("${sonar.host}")
    private String host = "http://sc.hikops.com/";

    @Value("${sonar.api.auth}")
    private String api = "api/authentication/login";

    private String url = host+api;
    private String login = "login=admin&password=Hik12345+";

    RequestHandler requestHandler = new RequestHandler(url, login);

    public String getResult() throws Exception{
        String result = requestHandler.postUrl();
        return result;
    }
}
