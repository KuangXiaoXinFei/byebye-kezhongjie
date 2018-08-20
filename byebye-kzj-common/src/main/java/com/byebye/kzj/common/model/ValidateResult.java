package com.byebye.kzj.common.model;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/5 10:15  by  李娜（lina@cloud-young.com）创建
 */
public class ValidateResult {
    private boolean isValid;
    private String validateMsg;

    public ValidateResult() {
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setValid(boolean valid) {
        this.isValid = valid;
    }

    public String getValidateMsg() {
        return this.validateMsg;
    }

    public void setValidateMsg(String validateMsg) {
        this.validateMsg = validateMsg;
    }
}
