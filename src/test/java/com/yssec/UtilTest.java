package com.yssec;

import com.yssec.sonarapi.ProjectsSearch;
import com.yssec.util.RequestHandler;
import org.junit.Test;

public class UtilTest {
//    @Test
//    public void test() throws Exception{
//        RequestHandler requestHandler = new RequestHandler("http://www.baidu.com", "GET","");
//        String r = requestHandler.getUrl();
//        System.out.println(r);
//    }

    @Test
    public void apitest() throws Exception{
        ProjectsSearch projectsSearch = new ProjectsSearch();
        String result = projectsSearch.getResult();
        System.out.println(result);
    }
}
