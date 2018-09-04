package com.me.inner.service;

import com.me.inner.dto.BaseUserDetails;
import com.me.inner.dto.LoginHistorySecDTO;
import com.me.inner.dto.ResourceSecDTO;
import com.me.inner.dto.RoleSecDTO;
import com.me.inner.mapper.SecurityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Me on 2018/8/18.
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private SecurityMapper securityMapper;

    public BaseUserDetails getUserByUsername(String username) {
        BaseUserDetails user = securityMapper.getUserByUsername(username);
        if (null != user) {
            ResourceSecDTO homeResource = securityMapper.getHomePageByUsername(username);
            if (null != homeResource) {
                user.setHomePage(homeResource.getResourcePath());
            }

            List<RoleSecDTO> roleList = securityMapper.listRoleByUsername(username);

            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            if (null != roleList && !roleList.isEmpty()) {
                for (RoleSecDTO role : roleList) {
                    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
                    authorities.add(authority);
                }
            }

            user.setAuthorities(authorities);
        }

        return user;
    }

    public void saveLoginHistory(LoginHistorySecDTO loginHistory) {
        securityMapper.saveLoginHistory(loginHistory);
    }
}
