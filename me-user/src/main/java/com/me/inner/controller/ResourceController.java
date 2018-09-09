package com.me.inner.controller;

import com.me.inner.dto.ResourceDTO;
import com.me.inner.dto.ResponseData;
import com.me.inner.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Me on 2018/9/9.
 */

@Controller
@RequestMapping("resource")
public class ResourceController {

    Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("listResource")
    public ModelAndView listResource() {
        logger.debug("Execute Method listResource...");

        return new ModelAndView("resource/listResource");
    }

    @RequestMapping("listResourceData")
    @ResponseBody
    public List<ResourceDTO> listResourceData() {
        logger.debug("Execute Method listResourceData...");

        return userService.listResource();
    }

    @RequestMapping("add")
    public ModelAndView addResource(@ModelAttribute("resourceForm") ResourceDTO resourceForm) {
        logger.debug("Execute Method addResource...");

        return new ModelAndView("resource/addResource");
    }

    @RequestMapping("submit")
    public ModelAndView submitResource(@ModelAttribute("resourceForm") ResourceDTO resourceForm) {
        logger.debug("Execute Method submitResource...");

        return new ModelAndView("resource/submitResource");
    }

    @RequestMapping("confirm")
    public ModelAndView confirmResource(@ModelAttribute("resourceForm") ResourceDTO resourceForm) {
        logger.debug("Execute Method confirmResource...");

        userService.saveResource(resourceForm);

        return new ModelAndView("redirect:/resource/listResource");
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResponseData deleteResource(@ModelAttribute("resourceId") Integer resourceId) {
        logger.debug("Execute Method deleteResource...");


        try {
            userService.deleteResource(resourceId);
        } catch (Exception e) {
            logger.error("delete resource failed...", e);
            return new ResponseData(Boolean.FALSE);
        }

        return new ResponseData(Boolean.TRUE);
    }
}
