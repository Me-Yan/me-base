package com.me.inner.mapper;


import com.me.inner.dto.BaseUserDetails;
import com.me.inner.dto.LoginHistorySecDTO;
import com.me.inner.dto.ResourceSecDTO;
import com.me.inner.dto.RoleSecDTO;

import java.util.List;

/**
 * Created by Me on 2018/8/18.
 */
public interface SecurityMapper {

    BaseUserDetails getUserByUsername(String username);

    ResourceSecDTO getHomePageByUsername(String username);

    List<RoleSecDTO> listRoleByUsername(String username);

    List<ResourceSecDTO> listResourceByUsername(String username);

    void saveLoginHistory(LoginHistorySecDTO loginHistorySecDTO);
}
