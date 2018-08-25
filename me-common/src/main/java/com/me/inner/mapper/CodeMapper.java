package com.me.inner.mapper;

import com.me.inner.dto.CodeDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yanyanghong on 2018/8/23.
 */
public interface CodeMapper {

    List<CodeDTO> listCodeByType(String type);

    CodeDTO getCodeByTypeAndName(@Param("type") String type, @Param("name") String name);
}
