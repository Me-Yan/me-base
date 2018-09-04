package com.me.inner.service;

import com.me.inner.constant.CommonConstant;
import com.me.inner.dto.CodeDTO;
import com.me.inner.dto.PaginationDTO;
import com.me.inner.mapper.CodeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by yanyanghong on 2018/8/23.
 */
@Service
public class CodeServiceImpl implements CodeService {

    private Logger logger = LoggerFactory.getLogger(CodeServiceImpl.class);

    @Autowired
    private CodeMapper codeMapper;

    public List<String> listType() {
        logger.debug("Execute Method listType...");

        return codeMapper.listType();
    }

    public PaginationDTO listCodeByType(String type, PaginationDTO pagination) {
        logger.debug("Execute Method listCodeByType...");

        List<CodeDTO> codeList = codeMapper.listCodeByType(type, pagination);

        Integer count = CollectionUtils.isEmpty(codeList)?0:codeList.size();
        Integer totalPage = count / pagination.getLimit();

        pagination.setCount(count);
        pagination.setTotalPage(totalPage);
        pagination.setDataList(codeList);

        return pagination;
    }

    public CodeDTO getCodeByTypeAndName(String type, String name) {
        logger.debug("Execute Method getCodeByTypeAndName...");

        return codeMapper.getCodeByTypeAndName(type, name);
    }

    public void saveCode(CodeDTO code) {
        logger.debug("Execute Method saveCode...");

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        code.setActive(CommonConstant.YES_NO.YES);
        code.setCreateDate(new Date());
        code.setCreateBy(userDetails.getUsername());

        codeMapper.saveCode(code);
    }

    public void deleteCode(Integer codeId) {
        logger.debug("Execute Method deleteCode...");

        codeMapper.deleteCode(codeId);
    }
}
