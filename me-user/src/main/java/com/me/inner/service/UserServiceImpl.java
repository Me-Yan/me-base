package com.me.inner.service;

import com.google.common.collect.Lists;
import com.me.inner.dto.*;
import com.me.inner.mapper.UserMapper;
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
 * Created by Me on 2018/9/4.
 */

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    public List<UserDTO> listUserByRole(String roleName, PaginationDTO pagination) {
        logger.debug("Execute Method listUserByRole...");

        return userMapper.listUserByRole(roleName, pagination);
    }

    public List<RoleDTO> listRole() {
        logger.debug("Execute Method listRole...");

        return userMapper.listRole();
    }

    public List<ResourceDTO> listResource() {
        logger.debug("Execute Method listResource...");

        return userMapper.listResource();
    }

    public List<LoginHistoryDTO> listLoginHistory(PaginationDTO pagination) {
        logger.debug("Execute Method listLoginHistory...");

        return userMapper.listLoginHistory(pagination);
    }

    public void saveUser(UserDTO user) {
        logger.debug("Execute Method saveUser...");

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Date curDate = new Date();

        userMapper.saveUser(user);
        if (!CollectionUtils.isEmpty(user.getRoleList())) {
            List<User2RoleDTO> user2RoleList = Lists.newArrayList();
            for (RoleDTO role : user.getRoleList()) {
                User2RoleDTO user2Role = new User2RoleDTO();
                user2Role.setUserId(user.getUserId());
                user2Role.setRoleId(role.getRoleId());
                user2Role.setCreateDate(curDate);
                user2Role.setCreateBy(userDetails.getUsername());

                user2RoleList.add(user2Role);
            }

            userMapper.saveUser2Role(user2RoleList);
        }

    }

    public void deleteUser(Integer userId) {
        logger.debug("Execute Method deleteUser...");

        userMapper.deleteUser(userId);
        userMapper.deleteUser2Role(userId);
    }

    public void saveRole(RoleDTO role) {
        logger.debug("Execute Method saveRole...");

        userMapper.saveRole(role);
    }

    public void deleteRole(Integer roleId) {
        logger.debug("Execute Method deleteRole...");

        userMapper.deleteRole(roleId);
        userMapper.deleteRole2Res(roleId, null);
    }

    public void saveResource(ResourceDTO resource) {
        logger.debug("Execute Method saveResource...");

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        userMapper.saveResource(resource);

        Role2ResourceDTO role2Resource = new Role2ResourceDTO();
        role2Resource.setRoleId(resource.getRole().getRoleId());
        role2Resource.setCreateDate(new Date());
        role2Resource.setCreateBy(userDetails.getUsername());

        userMapper.saveRole2Resource(role2Resource);
    }

    public void deleteResource(Integer resourceId) {
        logger.debug("Execute Method deleteResource...");

        userMapper.deleteResource(resourceId);
        userMapper.deleteRole2Res(null, resourceId);
    }
}
