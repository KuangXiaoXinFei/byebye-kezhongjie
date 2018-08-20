package com.byebye.kzj.service.apiservice.impl;

import com.byebye.kzj.dao.UserTokenMapper;
import com.byebye.kzj.model.UserToken;
import com.byebye.kzj.model.UserTokenExample;
import com.byebye.kzj.service.apiservice.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/10 16:59  by  侯春春（houcc@cloud-young.com）创建
 */
@Service("userTokenService")
public class UserTokenServiceImpl implements UserTokenService {
    @Autowired
    private UserTokenMapper userTokenMapper;

    @Override
    public UserToken getByToken(String token) {
        UserTokenExample example = new UserTokenExample();
        UserTokenExample.Criteria criteria = example.createCriteria();
        criteria.andIsActiveEqualTo(1);
        criteria.andTokenEqualTo(token);
        example.setOrderByClause("update_time desc");
        List<UserToken> list = userTokenMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    public UserToken refresh(int userId, String ip, String platform, String version) {
        try {
            if (userId < 0) {
                throw new RuntimeException("用户Id不符合规范");
            }
            UserToken token = new UserToken();
            Date datenow = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(datenow);
            calendar.add(Calendar.WEEK_OF_YEAR, 1);
            Date expireTime = calendar.getTime();

            token.setUserId(userId);
            token.setToken(UUID.randomUUID().toString().replace("-", ""));
            token.setIp(ip);
            token.setPlatform(platform);
            token.setVersion(version);
            token.setUpdateTime(datenow);
            token.setExpireTime(expireTime);
            token.setIsActive(1);

            UserToken oldToken = getByUserIdAndExpireTime(userId);
            if (oldToken == null) {
                //新建
                token.setCreateTime(datenow);
                add(token);
            } else {
                Date oldExpireTime = oldToken.getExpireTime();
                if (new Date().compareTo(oldExpireTime) < 0) {
                    token.setId(oldToken.getId());
                    updateByPrimaryKeySelective(token);
                } else {
                    //新建
                    token.setCreateTime(datenow);
                    add(token);
                }
            }

            return token;
        } catch (Exception err) {
            throw new RuntimeException(err);
        }
    }

    @Override
    public int updateExpireTimeInvalid(int userid) {
        UserToken oldUserToken = getByUserIdAndExpireTime(userid);
        if (oldUserToken != null) {
            UserToken userToken = new UserToken();
            userToken.setId(oldUserToken.getId())
                    .setUserId(userid)
                    .setExpireTime(new Date(2000 - 1900, 1 - 1, 1, 0, 0, 0));
            return userTokenMapper.updateByPrimaryKeySelective(userToken);
        }
        return 0;
    }

    public UserToken getByUserIdAndExpireTime(int userId) {
        UserTokenExample example = new UserTokenExample();
        UserTokenExample.Criteria criteria = example.createCriteria();
        criteria.andIsActiveEqualTo(1);
        criteria.andUserIdEqualTo(userId);
        example.setOrderByClause("update_time desc");
//        criteria.andExpireTimeGreaterThanOrEqualTo(new Date());
        List<UserToken> list = userTokenMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public int add(UserToken token) {
        return userTokenMapper.insert(token);
    }

    public int updateByPrimaryKeySelective(UserToken token) {
        return userTokenMapper.updateByPrimaryKeySelective(token);
    }
}
