package com.qishon.test;

import com.qishon.utils.UrlConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Gs_prod_getProdOrdDetail {

    @Test(groups = "LoginTrue",description = "根据款式版型获取默认定制详情接口测试")
    public void Gs_prod_getProdOrdDetailTest(){
        Response response = given()
                .auth().oauth2(UrlConfig.access_token)
                .get(UrlConfig.gs_prod_getProdOrdDetail_url);
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
