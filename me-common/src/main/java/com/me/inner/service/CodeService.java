package com.me.inner.service;


import com.me.inner.dto.CodeDTO;
import com.me.inner.dto.PaginationDTO;

import java.util.List;

/**
 * Created by yanyanghong on 2018/8/23.
 */
public interface CodeService {

    List<String> listType();

    PaginationDTO listCodeByType(String type, PaginationDTO pagination);

    CodeDTO getCodeByTypeAndName(String type, String name);

}
