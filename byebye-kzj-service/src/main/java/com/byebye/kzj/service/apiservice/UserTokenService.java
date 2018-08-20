package com.byebye.kzj.service.apiservice;


import com.byebye.kzj.model.UserToken;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/10 17:00  by  侯春春（houcc@cloud-young.com）创建1
 */
public interface UserTokenService {
    UserToken getByToken(String token);

    UserToken refresh(int userId, String ip, String platform, String version);

    int updateExpireTimeInvalid(int userid);
}
