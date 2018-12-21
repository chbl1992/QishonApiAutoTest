package com.qishon.test;

import com.qishon.utils.UrlConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Gs_prod_getProdInfo {

    @Test(groups = "LoginTest",description = "获取商品基本信息接口测试")
    public void Gs_prod_getProdInfoTest(){
        Response response = given()
                .auth().oauth2(UrlConfig.access_token)
                .get(UrlConfig.gs_prod_getProdInfo_url);
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
