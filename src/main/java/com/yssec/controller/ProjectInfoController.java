package com.yssec.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yssec.model.Paging;
import com.yssec.sonarapi.ProjectsSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/projects")
public class ProjectInfoController {
    @Autowired
    private ProjectsSearch projectsSearch;
    @RequestMapping("/info")
    public ModelAndView info() throws Exception{

        String jsonresult = projectsSearch.getResult();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(jsonresult);
        String page = node.get("paging").toString();
        Paging paging = mapper.readValue(page, Paging.class);

        ModelAndView modelAndView = new ModelAndView("/total");
        modelAndView.addObject("paging", paging);
        return modelAndView;
    }
}
