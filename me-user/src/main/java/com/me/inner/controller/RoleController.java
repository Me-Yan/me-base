package com.me.inner.controller;

import com.me.inner.dto.PaginationDTO;
import com.me.inner.dto.ResponseData;
import com.me.inner.dto.RoleDTO;
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
@RequestMapping("role")
public class RoleController {

    Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("listRole")
    public ModelAndView listRole() {
        logger.debug("Execute Method listRole...");

        return new ModelAndView("role/listRole");
    }

    @RequestMapping("listRoleData")
    @ResponseBody
    public List<RoleDTO> listRoleData() {
        logger.debug("Execute Method listRoleData...");

        return userService.listRole();
    }

    @RequestMapping("add")
    public ModelAndView addRole(@ModelAttribute("RoleForm") RoleDTO roleForm) {
        logger.debug("Execute Method addRole...");

        return new ModelAndView("role/addRole");
    }

    @RequestMapping("submit")
    public ModelAndView submitRole(@ModelAttribute("RoleForm") RoleDTO roleForm) {
        logger.debug("Execute Method submitRole...");

        return new ModelAndView("role/submitRole");
    }

    @RequestMapping("confirm")
    public ModelAndView confirmRole(@ModelAttribute("RoleForm") RoleDTO roleForm) {
        logger.debug("Execute Method confirmRole...");

        userService.saveRole(roleForm);

        return new ModelAndView("role/confirmRole");
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResponseData deleteRole(@ModelAttribute("roleId") Integer roleId) {
        logger.debug("Execute Method deleteRole...");

        try {
            userService.deleteRole(roleId);
        } catch (Exception e) {
            logger.error("delete role failed...", e);
            return new ResponseData(Boolean.FALSE);
        }

        return new ResponseData(Boolean.TRUE);
    }
}
