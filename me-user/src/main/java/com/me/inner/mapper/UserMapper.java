package com.me.inner.mapper;

import com.me.inner.dto.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Me on 2018/9/4.
 */
public interface UserMapper {

    Integer countUserByRole(String roleName);

    List<UserDTO> listUserByRole(@Param("roleName") String roleName, @Param("pagination") PaginationDTO pagination);

    List<RoleDTO> listRole();

    List<ResourceDTO> listResource();

    Integer countLoginHistory();

    List<LoginHistoryDTO> listLoginHistory(PaginationDTO pagination);

    void saveUser(UserDTO user);

    void saveUser2Role(List<User2RoleDTO> user2RoleList);

    void deleteUser(Integer userId);

    void deleteUser2Role(Integer userId);

    void saveRole(RoleDTO role);

    void deleteRole(Integer roleId);

    void deleteRole2Res(@Param("roleId") Integer roleId, @Param("resId") Integer resId);

    void saveResource(ResourceDTO resource);

    void saveRole2Resource(Role2ResourceDTO role2Resource);

    void deleteResource(Integer resourceId);

    void resetPassword(UserDTO user);
}
