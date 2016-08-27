package com.cms.controller;

import com.cms.dto.ProjectDTO;
import com.cms.dto.UserDTO;
import com.cms.service.IAdminService;
import com.cms.service.RequestUrlToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
/*@Secured("ROLE_ADMIN")*/

@RequestMapping("/all")
public class DefaultController {

    @Autowired
    private IAdminService adminService;

    @RequestMapping(value = RequestUrlToken.GET_PROJECTS_BY_FISCAL_YEAR, method = RequestMethod.GET)
    @ResponseBody
    public List<ProjectDTO> showAllProjects(@PathVariable String fiscalYear)  throws JsonProcessingException {
        List<ProjectDTO> pjs = adminService.getAllProjectsByFiscalYear(fiscalYear);
        return pjs;
    }
    @RequestMapping(value = RequestUrlToken.GET_PROJECT, method = RequestMethod.GET)
    @ResponseBody
    public ProjectDTO getSingleProject(@PathVariable Integer id)
            throws JsonProcessingException {

        return adminService.getProject(id);
    }








}