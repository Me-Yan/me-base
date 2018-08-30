package com.me.inner.controller;

import com.me.inner.dto.CodeDTO;
import com.me.inner.service.CodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

        List<CodeDTO> codeList = codeService.listAllCode();

        model.addObject("codeList", codeList);

        return model;
    }
}
