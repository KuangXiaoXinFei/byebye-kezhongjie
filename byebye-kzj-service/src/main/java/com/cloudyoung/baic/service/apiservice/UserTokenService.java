package com.cloudyoung.baic.service.apiservice;


import com.cloudyoung.baic.model.UserToken;

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
