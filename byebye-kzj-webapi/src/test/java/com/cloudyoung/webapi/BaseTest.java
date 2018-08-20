package com.cloudyoung.webapi;

import com.alibaba.fastjson.JSON;
import com.byebye.kzj.common.utils.DateUtil;
import com.byebye.kzj.webapi.CloudBaicWebapiApplication;
import com.byebye.kzj.webapi.intercepter.SignValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CloudBaicWebapiApplication.class)
public class BaseTest {

    @Test
    public void contextLoads() {
        System.out.println(1);
    }

    @Test
    public void getCurrentTime(){
        long millLong=System.currentTimeMillis();
        Date d=new Date(millLong);
        System.out.println("currentTimeMillis="+millLong);
        System.out.println("currentTime="+ DateUtil.formatDateTime(d,"yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void TestSign() {

        Map map = new HashMap();
        map.put("brand", "xiaomi");
        map.put("mobile_model", "MIX2S");
        map.put("system_version", "8.0.1");
        map.put("screenpixel", "1024*768");
        map.put("version", "1.0.0");
        map.put("network_type", "wift");
        map.put("platform", "Android");

        // --
        Map bodyMap = new HashMap();
        bodyMap.put("newsId", "0");
        bodyMap.put("newsType", "1");
        bodyMap.put("title", "16test长期以来，说起自主品牌");
        bodyMap.put("newsContent", "[{\"type\":1,\"value\":\"    16test1111长期以来，说起自主品牌\"},{\"type\":2,\"value\":\"http://inews.gtimg.com/newsapp_match/0/3449726078/0\"}]");
//        bodyMap.put("minId", "12");
//        bodyMap.put("pageSize", "10");

        Map signMap = new HashMap(map);
        signMap.putAll(bodyMap);
        String sign = SignValidator.generateSignature(signMap, "60d86604bb0644d299f9ee5b09db5280");

        Map reqestMap = new HashMap();
        reqestMap.put("UA", JSON.toJSONString(map));
        reqestMap.put("token", "60d86604bb0644d299f9ee5b09db5280");
        reqestMap.put("sign", sign);
        reqestMap.put("body", JSON.toJSONString(bodyMap));

        Set<Map.Entry<String, String>> setMap= reqestMap.entrySet();
        for (Map.Entry<String, String> entry : setMap) {
            System.out.println(entry.getKey()+"=" + entry.getValue());
        }
        System.out.println("---end---");

    }

}
