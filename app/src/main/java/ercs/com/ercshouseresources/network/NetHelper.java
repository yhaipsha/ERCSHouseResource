package ercs.com.ercshouseresources.network;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/23.
 * 网络接口访问辅助类
 */

public class NetHelper {
    public static final String URL = "http://192.168.1.157:8001";//IP地址
    private static final String LOGIN = "/API/Account/LOGIN";//用户登录
    private static final String CLERK = "/API/User/UserList";//职员列表
    private static final String PROCESS = "/API/Leave/LeaveApprovaList";//流程审批
    private static final String PROCESSCONTENT = "/API/Leave/LeaveInfo";//流程审批详细接口
    private static final String PROCESSREVIEW = "/API/Leave/ApprovalLeave";//流程审批接口
    private static final String SCHEDULING = "/API/PaiBan/OnDutyList";//排班情况接口
    private static final String ATENDANCE = "/API/InSide/UserInSideList";//考勤统计接口
    private static final String OUTSIDE = "/API/OutSide/OutSideList";//外勤统计接口
    private static final String LEAVEALL = "/API/Leave/LeaveAllList";//所有流程接口
    private static final String INSIDE = "/API/InSide/InSideInfo";//打卡信息接口
    private static final String INSIDESETINFO = "/API/InSide/InSideSetInfo";//打卡设置信息接口
    private static final String UPLOADPIC = "/API/OutSide/UploadImageAsync";//上传打开图片
    private static final String PUNCHCLOCK = "/API/InSide/InsertInSide";//打卡接口

    /**
     * 登录
     *
     * @param id       pwd
     * @param callback
     */
    public static void login(String id, String pwd, HttpUtils.HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("userName", id);
        map.put("password", pwd);
        String json = MyGson.getInstance().toJson(map);
        new HttpUtils().postLoginJson(URL + LOGIN, json, callback);
    }

    /**
     * 职员列表
     *
     * @param id
     * @param callback
     */
    public static void clerk(String id, HttpUtils.HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("Id", "0");
        String json = MyGson.getInstance().toJson(map);
        new HttpUtils().postJson(URL + CLERK, json, callback);
    }

    /**
     * 流程审批
     *
     * @param id
     * @param callback
     */
    public static void process(String id, HttpUtils.HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("ApprovalUserId", "2");
        String json = MyGson.getInstance().toJson(map);
        new HttpUtils().postJson(URL + PROCESS, json, callback);
    }

    /**
     * 流程审批详细接口
     *
     * @param id
     * @param LeaveType
     * @param callback
     */
    public static void processContent(String id, String LeaveType, HttpUtils.HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("Id", id);
        map.put("LeaveType", LeaveType);
        String json = MyGson.getInstance().toJson(map);
        new HttpUtils().postJson(URL + PROCESSCONTENT, json, callback);
    }

    /**
     * 流程审批接口
     *
     * @param id
     * @param LeaveType
     * @param LeaveState
     * @param ApprovalContent
     * @param ApprovalUserId
     * @param callback
     */
    public static void processReview(String id, String LeaveType, String LeaveState, String ApprovalContent, String ApprovalUserId, HttpUtils.HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("Id", id);
        map.put("LeaveType", LeaveType);
        map.put("LeaveState", LeaveState);//同意2 不同意3
        map.put("ApprovalContent", ApprovalContent);
        map.put("ApprovalUserId", ApprovalUserId);
        String json = MyGson.getInstance().toJson(map);
        new HttpUtils().postJson(URL + PROCESSREVIEW, json, callback);
    }

    /**
     * 排班情况接口
     *
     * @param ParamsDate
     * @param callback
     */
    public static void scheduling(String ParamsDate, HttpUtils.HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("ParamsDate", ParamsDate);
        String json = MyGson.getInstance().toJson(map);
        new HttpUtils().postJson(URL + SCHEDULING, json, callback);
    }

    /**
     * 考勤统计接口
     *
     * @param UserId
     * @param date
     * @param callback
     */
    public static void atendance(String UserId, String date, HttpUtils.HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("UserId", "2");
        map.put("ParamsDate", date);
        String json = MyGson.getInstance().toJson(map);
        new HttpUtils().postJson(URL + ATENDANCE, json, callback);
    }

    /**
     * 外勤统计接口
     *
     * @param CreatorId
     * @param ParamsDate
     * @param callback
     */
    public static void outside(String CreatorId, String ParamsDate, HttpUtils.HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("CreatorId", "2");
        map.put("ParamsDate", ParamsDate);
        String json = MyGson.getInstance().toJson(map);
        new HttpUtils().postJson(URL + OUTSIDE, json, callback);
    }

    /**
     * 所有流程的接口
     *
     * @param UserId
     * @param callback
     */
    public static void leavealllis(String UserId, HttpUtils.HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("UserId", "2");
        String json = MyGson.getInstance().toJson(map);
        new HttpUtils().postJson(URL + LEAVEALL, json, callback);
    }

    /**
     * 打卡信息接口
     *
     * @param UserId
     * @param callback
     */
    public static void inside(String ParamsDate, String UserId, HttpUtils.HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("ParamsDate", "2017-06-24");
        map.put("UserId", "2");
        String json = MyGson.getInstance().toJson(map);
        new HttpUtils().postJson(URL + INSIDE, json, callback);
    }

    /**
     * 打卡设置信息
     *
     * @param UserId
     * @param callback
     */
    public static void insideSetInfo(String UserId, HttpUtils.HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("UserId", "2");
        String json = MyGson.getInstance().toJson(map);
        new HttpUtils().postJson(URL + INSIDESETINFO, json, callback);
    }

    /**
     * 上传打卡图片
     *
     * @param Imagedata
     * @param callback
     */
    public static void uploadPic(String Imagedata, HttpUtils.HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("Imagedata", Imagedata);
        String json = MyGson.getInstance().toJson(map);
        new HttpUtils().postJson(URL + UPLOADPIC, json, callback);
    }

    /**
     * 上班打卡接口
     * @param
     * @param Id
     * @param callback
     */
    public static void punchClock(String StartImagePage ,String Id,String CreatorId,String StartLocation, HttpUtils.HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("Id", Id);
        map.put("StartImagePage", StartImagePage);
        map.put("CreatorId", CreatorId);
        map.put("StartContent", "1");
        map.put("StartLocation", StartLocation);
        String json = MyGson.getInstance().toJson(map);
        Log.d("Json",json);
        new HttpUtils().postJson(URL + PUNCHCLOCK, json, callback);
    }
    /**
     * 下班打卡接口
     * @param
     * @param Id
     * @param callback
     */
    public static void punchClock2(String EndImagePage ,String Id,String CreatorId,String EndLocation, HttpUtils.HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("Id", Id);
        map.put("EndImagePage", EndImagePage);
        map.put("CreatorId", CreatorId);
        map.put("EndContent", "1");
        map.put("EndLocation", EndLocation);
        String json = MyGson.getInstance().toJson(map);
        new HttpUtils().postJson(URL + PUNCHCLOCK, json, callback);
    }
}