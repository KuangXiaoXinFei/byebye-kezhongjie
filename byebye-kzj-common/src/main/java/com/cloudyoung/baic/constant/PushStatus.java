package com.cloudyoung.baic.constant;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/16 14:19  by  侯春春（houcc@cloud-young.com）创建
 */
public enum PushStatus {
    NotSend(0, "NotSend"),
    Send(1, "Send");

    private int source;
    private String remark;

    private PushStatus(int source, String remark) {
        this.source = source;
        this.remark = remark;
    }

    public int getSource() {
        return this.source;
    }

    public String getRemark() {
        return this.remark;
    }

    public static PushStatus getEnum(int source) {
        PushStatus[] enums = values();
        PushStatus state = null;
        for (int i = 0; i < enums.length; i++) {
            if (source == enums[i].getSource()) {
                state = enums[i];
                break;
            }
        }
        return state;
    }

    public static PushStatus getEnum(String remark) {
        PushStatus[] enums = values();
        PushStatus type = null;
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
