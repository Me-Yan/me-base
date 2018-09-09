package com.me.inner.controller;

import com.me.inner.dto.PaginationDTO;
import com.me.inner.dto.ResponseData;
import com.me.inner.dto.RoleDTO;
import com.me.inner.dto.UserDTO;
import com.me.inner.service.UserService;
import com.me.inner.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Me on 2018/9/4.
 */

@Controller
@RequestMapping("user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("listUser")
    public ModelAndView listUser() {
        logger.debug("Execute Method listUserByRole...");

        ModelAndView model = new ModelAndView("user/listUser");

        List<RoleDTO> roleList = userService.listRole();

        model.addObject("roleList", roleList);

        return model;
    }

    @RequestMapping("listUserData")
    @ResponseBody
    public PaginationDTO listUserData(@ModelAttribute("roleName") String roleName, HttpServletRequest request) {
        logger.debug("Execute Method listUserData...");

        PaginationDTO pagination = CommonUtil.packagePagination(request);

        return userService.listUserByRole(roleName, pagination);
    }

    @RequestMapping("add")
    public ModelAndView addUser(@ModelAttribute("userForm") UserDTO userForm) {
        logger.debug("Execute Method addUser...");

        return new ModelAndView("user/addUser");
    }

    @RequestMapping("submit")
    public ModelAndView submitUser(@ModelAttribute("userForm") UserDTO userForm) {
        logger.debug("Execute Method submitUser...");

        return new ModelAndView("user/submitUser");
    }

    @RequestMapping("confirm")
    public ModelAndView confirmUser(@ModelAttribute("userForm") UserDTO userForm) {
        logger.debug("Execute Method confirmUser...");

        userService.saveUser(userForm);

        return new ModelAndView("redirect:/user/listUser");
    }

    @RequestMapping("resetPassword")
    @ResponseBody
    public ResponseData resetPassword(@ModelAttribute("userForm") UserDTO userForm) {
        logger.debug("Execute Method resetPassword...");

        try {
            userService.updatePassword(userForm);
        } catch (Exception e) {
            logger.error("reset password failed.", e);
            return new ResponseData(Boolean.FALSE);
        }

        return new ResponseData(Boolean.TRUE);
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResponseData deleteUser(@ModelAttribute("userId") Integer userId) {
        logger.debug("Execute Method deleteUser...");

        try {
            userService.deleteUser(userId);
        } catch (Exception e) {
            logger.error("delete user failed.", e);
            return new ResponseData(Boolean.FALSE);
        }

        return new ResponseData(Boolean.TRUE);
    }
}
