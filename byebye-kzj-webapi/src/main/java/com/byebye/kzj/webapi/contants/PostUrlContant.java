package com.byebye.kzj.webapi.contants;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/7/6 16:53
 */
@Component
@Data
@Accessors(chain = true)
public class PostUrlContant {

    @Value("${liandian.sand-url.authirty_href}")
    private String authUrl;

    @Value("${liandian.sand-url.trouble-history-href}")
    private String troubleHistoryUrl;

    @Value("${liandian.sand-url.battery-life-href}")
    private String batteryLiftUrl;

    @Value("${liandian.sand-url.battery-power-href}")
    private String batteryPowerUrl;

    @Value("${liandian.sand-url.oil-wear-search-href}")
    private String oilWearSearchUrl;

    @Value("${liandian.sand-url.driving-style-href}")
    private String driveStyleUrl;

    @Value("${liandian.sand-url.power-sys-href}")
    private String powerSysUrl;

    @Value("${liandian.power-sys.good}")
    private String powerSysGood;

    @Value("${liandian.power-sys.nice}")
    private String powerSysNice;

    @Value("${liandian.power-sys.middle}")
    private String powerSysMiddle;

    @Value("${liandian.power-sys.notgood}")
    private String powerSysNotgood;

    @Value("${liandian.sand-url.oil-wear-setting-href}")
    private String oilWearSettingUrl;

    @Value("${liandian.sand-url.oil-wear-monitor-href}")
    private String oilWearMonitorUrl;

    @Value("${liandian.sand-url.oil-wear-attribute-href}")
    private String oilWearAttributeUrl;

    @Value("${liandian.sand-url.secretary-maintenance-href}")
    private String secretaryUrl;

    @Value("${liandian.sand-url.secretary-record-href}")
    private String secretaryRecord;

    @Value("${liandian.sand-url.gas-station-href}")
    private String gasStationUrl;

    @Value("${liandian.sand-url.surplus-oil-wear-href}")
    private String oilWearSurplusUrl;

    @Value("${keda.sand-url.tsp-locatioin-href}")
    private String kedaCarLocationUrl;

}
