package com.me.inner.controller;

import com.me.inner.constant.CommonConstant;
import com.me.inner.dto.CodeDTO;
import com.me.inner.dto.PaginationDTO;
import com.me.inner.dto.ResponseData;
import com.me.inner.service.CodeService;
import com.me.inner.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Me on 2018/8/30.
 */
@Controller
@RequestMapping("code")
public class CodeController {

    private Logger logger = LoggerFactory.getLogger(CodeController.class);

    @Autowired
    private CodeService codeService;

    @RequestMapping("list")
    public ModelAndView listCode() {
        logger.debug("Execute Method listCode...");

        ModelAndView model = new ModelAndView("code/listCode");

        List<String> codeTypeList = codeService.listType();

        model.addObject("codeTypeList", codeTypeList);

        return model;
    }

    @RequestMapping("listCodeData")
    @ResponseBody
    public List<CodeDTO> listCodeData(@RequestParam(name = "type", required = false) String type) {
        logger.debug("Execute Method listCodeData...");

        return codeService.listCodeByType(type);
    }

    @RequestMapping("add")
    public ModelAndView addCode(@ModelAttribute("codeForm") CodeDTO codeForm) {
        logger.debug("Execute Method addCode...");

        return new ModelAndView("code/addCode");
    }

    @RequestMapping("submit")
    public ModelAndView submitCode(@ModelAttribute("codeForm") CodeDTO codeForm) {
        logger.debug("Execute Method submitCode...");

        return new ModelAndView("code/addCode");
    }

    @RequestMapping("confirm")
    public ModelAndView confirmCode(@ModelAttribute("codeForm") CodeDTO codeForm, RedirectAttributes attributes) {
        logger.debug("Execute Method confirmCode...");

        codeService.saveCode(codeForm);

        return new ModelAndView("redirect:/code/list");
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResponseData deleteCode(@ModelAttribute("codeId") Integer codeId) {
        logger.debug("Execute Method deleteCode...");

        try {

            codeService.deleteCode(codeId);
        } catch (Exception e) {
            logger.error("occur a error when delete a code", e);

            return new ResponseData(Boolean.FALSE, "occur a error.");
        }

        return new ResponseData(Boolean.TRUE, null);
    }
}
