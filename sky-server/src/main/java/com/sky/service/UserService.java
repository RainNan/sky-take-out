package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;
import com.sky.vo.UserReportVO;

public interface UserService {

    User wxLogin(UserLoginDTO userLoginDTO);
}
