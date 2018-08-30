package com.me.inner.service;


import com.me.inner.dto.CodeDTO;

import java.util.List;

/**
 * Created by yanyanghong on 2018/8/23.
 */
public interface CodeService {

    List<CodeDTO> listCodeByType(String type);

    CodeDTO getCodeByTypeAndName(String type, String name);

    List<CodeDTO> listAllCode();
}
