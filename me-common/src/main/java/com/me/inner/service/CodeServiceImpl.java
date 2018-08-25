package com.me.inner.service;

import com.me.inner.dto.CodeDTO;
import com.me.inner.mapper.CodeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yanyanghong on 2018/8/23.
 */
@Service
public class CodeServiceImpl implements CodeService {

    private Logger logger = LoggerFactory.getLogger(CodeServiceImpl.class);

    @Autowired
    private CodeMapper codeMapper;

    public List<CodeDTO> listCodeByType(String type) {
        logger.debug("Execute Method listCodeByType...");

        return codeMapper.listCodeByType(type);
    }

    public CodeDTO getCodeByTypeAndName(String type, String name) {
        logger.debug("Execute Method getCodeByTypeAndName...");

        return codeMapper.getCodeByTypeAndName(type, name);
    }
}
