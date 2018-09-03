package com.me.inner.controller;

import com.me.inner.dto.CodeDTO;
import com.me.inner.dto.PaginationDTO;
import com.me.inner.service.CodeService;
import com.me.inner.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("listCode")
    public ModelAndView listCode() {
        logger.debug("Execute Method listCode...");

        ModelAndView model = new ModelAndView("code/listCode");

        List<String> codeTypeList = codeService.listType();

        model.addObject("codeTypeList", codeTypeList);

        return model;
    }

    @RequestMapping("listCodeData")
    @ResponseBody
    public PaginationDTO listCodeData(String type, HttpServletRequest request) {
        logger.debug("Execute Method listCodeData...");

        PaginationDTO pagination = CommonUtil.packagePagination(request);

        pagination = codeService.listCodeByType(type, pagination);

        return pagination;
    }
}
