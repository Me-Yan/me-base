package com.me.inner.service;


import com.me.inner.dto.BaseUserDetails;
import com.me.inner.dto.LoginHistorySecDTO;

/**
 * Created by Me on 2018/8/18.
 */
public interface SecurityService {

    BaseUserDetails getUserByUsername(String username);

    public void saveLoginHistory(LoginHistorySecDTO loginHistory);
}
