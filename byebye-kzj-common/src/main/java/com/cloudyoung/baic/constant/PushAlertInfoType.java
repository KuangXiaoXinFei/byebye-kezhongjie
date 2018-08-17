package com.cloudyoung.baic.constant;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/16 14:04  by  侯春春（houcc@cloud-young.com）创建
 */
public enum PushAlertInfoType {
    FuelWarn(1, "FuelWarn"),//邮箱告警
    ComponentLevel(2, "ComponentLevel"),//零部件告警
    Notice(3, "Notice");//一般消息

    private int source;
    private String remark;

    private PushAlertInfoType(int source, String remark) {
        this.source = source;
        this.remark = remark;
    }

    public int getSource() {
        return this.source;
    }

    public String getRemark() {
        return this.remark;
    }

    public static PushAlertInfoType getEnum(int source) {
        PushAlertInfoType[] enums = values();
        PushAlertInfoType state = null;
        for (int i = 0; i < enums.length; i++) {
            if (source == enums[i].getSource()) {
                state = enums[i];
                break;
            }
        }
        return state;
    }

    public static PushAlertInfoType getEnum(String remark) {
        PushAlertInfoType[] enums = values();
        PushAlertInfoType type = null;
        for (int i = 0; i < enums.length; i++) {
            if (remark.toLowerCase().equals(enums[i].getRemark().toLowerCase())) {
                type = enums[i];
                break;
            }
        }
        return type;
    }

    @Override
    public String toString() {
        return this.remark;
    }
}
