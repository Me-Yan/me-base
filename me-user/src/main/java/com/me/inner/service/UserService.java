package com.me.inner.service;

import com.me.inner.dto.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Me on 2018/9/4.
 */
public interface UserService {

    PaginationDTO listUserByRole(@Param("roleName") String roleName, @Param("pagination") PaginationDTO pagination);

    List<RoleDTO> listRole();

    List<ResourceDTO> listResource();

    PaginationDTO listLoginHistory(PaginationDTO pagination);

    void saveUser(UserDTO user);

    void deleteUser(Integer userId);

    void saveRole(RoleDTO role);

    void deleteRole(Integer roleId);

    void saveResource(ResourceDTO resource);

    void deleteResource(Integer resourceId);

    void updatePassword(UserDTO user);

    // be using
    void updateUser(UserDTO user);
}
