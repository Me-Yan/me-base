package com.me.inner.mapper;


import com.me.inner.dto.BaseUserDetails;
import com.me.inner.dto.LoginHistoryDTO;
import com.me.inner.dto.ResourceDTO;
import com.me.inner.dto.RoleDTO;

import java.util.List;

/**
 * Created by Me on 2018/8/18.
 */
public interface SecurityMapper {

    BaseUserDetails getUserByUsername(String username);

    ResourceDTO getHomePageByUsername(String username);

    List<RoleDTO> listRoleByUsername(String username);

    List<ResourceDTO> listResourceByUsername(String username);

    void saveLoginHistory(LoginHistoryDTO loginHistoryDTO);
}
