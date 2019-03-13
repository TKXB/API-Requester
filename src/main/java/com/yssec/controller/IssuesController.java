package com.yssec.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yssec.domain.LearnResouce;
import com.yssec.model.Issues;
import com.yssec.model.NewIssueBean;
import com.yssec.sonarapi.NewIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

@Controller
@RequestMapping("/issues")
public class IssuesController {
    @Autowired
    private NewIssue newIssue;

    static List<Issues> issuesList = new ArrayList<Issues>();

    @RequestMapping("/new")
    public ModelAndView newissue() throws Exception{
        List<NewIssueBean> newIssuesList = new ArrayList<NewIssueBean>();

        String newIssueResult = newIssue.getResult();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(newIssueResult);
        JsonNode issNode = node.get("issues");
        jsonLeaf(issNode);
        for (Issues iss: issuesList){
            String updateDate = iss.getUpdateDate();
            if(isWithinOneWeek(updateDate)){
                NewIssueBean newIssueBean = new NewIssueBean();
                newIssueBean.setProject(iss.getProject());
                newIssueBean.setComponent(iss.getComponent());
                newIssueBean.setTime(iss.getUpdateDate());
                newIssuesList.add(newIssueBean);
            }
        }
        ModelAndView modelAndView = new ModelAndView("/issues");
        modelAndView.addObject("issuesList", newIssuesList);
        return modelAndView;
    }

    public static boolean isWithinOneWeek(String nowTime) throws ParseException {
        SimpleDateFormat Fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+0800'");
        Date cTime = Fmt.parse(nowTime);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, - 7);
        Date wTime = c.getTime();
        return wTime.before(cTime);

    }

    public static void jsonLeaf(JsonNode node) throws IOException {

        if (node.isObject())
        {
            ObjectMapper mapper = new ObjectMapper();
            Issues issue = mapper.readValue(node.toString(), Issues.class);
            issuesList.add(issue);
            return;
        }

        if (node.isArray())
        {
            Iterator<JsonNode> it = node.iterator();
            while (it.hasNext())
            {
                jsonLeaf(it.next());
            }
        }
    }
}
