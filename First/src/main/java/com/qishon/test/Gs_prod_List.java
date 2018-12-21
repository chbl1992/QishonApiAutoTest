package com.qishon.test;

import com.qishon.utils.UrlConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Gs_prod_List {

    @Test(groups = "LoginTest",description = "获取商品墙商品列表接口测试")
    public void Gs_prod_List(){
        Response response = given()
                .contentType("application/json")
                .auth().oauth2(UrlConfig.access_token)
                .body("{\"filters\":null,\"keyword\":\"\",\"origin\":\"goods\",\"pageNum\":1,\"range\":null,\"pageSize\":15,\"sortParam\":\"[{\\\"field\\\":\\\"sales\\\",\\\"order\\\":\\\"DESC\\\"}]\"}")
                .post(UrlConfig.gs_prod_list_url);
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
