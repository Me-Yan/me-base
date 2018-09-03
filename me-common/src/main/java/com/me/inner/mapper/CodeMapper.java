package com.me.inner.mapper;

import com.me.inner.dto.CodeDTO;
import com.me.inner.dto.PaginationDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yanyanghong on 2018/8/23.
 */
public interface CodeMapper {

    List<String> listType();

    List<CodeDTO> listCodeByType(@Param("type") String type, @Param("pagination") PaginationDTO pagination);

    CodeDTO getCodeByTypeAndName(@Param("type") String type, @Param("name") String name);
}
