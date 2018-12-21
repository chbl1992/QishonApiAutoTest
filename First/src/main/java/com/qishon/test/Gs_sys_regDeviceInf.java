package com.qishon.test;

import com.qishon.utils.UrlConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Gs_sys_regDeviceInf {

    @Test(groups = "Login",description = "设备注册接口测试")
    public void Gs_sys_regDeviceInfTest(){
        Response response = given()
                .contentType("application/json")
                .auth().oauth2(UrlConfig.access_token)
                .body("{\"usrKey\":null,\"shopCode\":\"QS0001\",\"deviceCode\":\"111\",\"brandCode\":null,\"usrName\":\"QS001\",\"loginPwd\":\"C33367701511B4F6020EC61DED352059\",\"jobType\":\"D_SHOPGUIDER\",\"languageCode\":\"zh-CN\",\"address\":\"qwe\",\"provinceCode\":\"110000\",\"cityCode\":\"110100\",\"districtCode\":\"110101\",\"deviceType\":\"D_DIPAD\",\"pwdFlag\":null}")
                .post(UrlConfig.gs_sys_regDeviceInf_url);
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
