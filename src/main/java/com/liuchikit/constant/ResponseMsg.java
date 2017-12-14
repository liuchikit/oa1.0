package com.liuchikit.constant;

/**
 * {类说明}
 *
 * @author liaozijie
 * @date 2017/11/15
 */
public enum ResponseMsg {

    SAVE_SUCCESS("保存成功"),
    SAVE_FAIL("保存失败"),
    DEL_SUCCESS("删除成功"),
    DEL_FAIL("删除失败"),
    UPDATE_SUCCESS("更新成功"),
    UPDATE_FAIL("更新失败"),
    GET_SUCCESS("获取成功"),
    GET_FAIL("获取失败");

    private String msg;
    ResponseMsg(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
