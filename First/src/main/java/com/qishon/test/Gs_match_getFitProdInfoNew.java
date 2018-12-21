package com.qishon.test;

import com.qishon.utils.UrlConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Gs_match_getFitProdInfoNew {

    @Test(groups = "LoginTest",description = "获取商品配件信息")
    public void Gs_match_getFitProdInfoNewTest(){
        Response response = given()
                .auth().oauth2(UrlConfig.access_token)
                .get(UrlConfig.gs_match_getFitProdInfoNew_url);
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
