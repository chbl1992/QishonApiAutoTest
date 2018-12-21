package com.qishon.test;

import com.qishon.utils.UrlConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Gs_sys_getPersonInfoByJob {

    @Test(groups = "LoginTest",description = "获取门店的导购员信息接口测试")
    public void Gs_sys_getPersonInfoByJobTest(){
        Response response = given()
                .auth().oauth2(UrlConfig.access_token)
                .get(UrlConfig.gs_sys_getPersoninFobyJob_url);
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
