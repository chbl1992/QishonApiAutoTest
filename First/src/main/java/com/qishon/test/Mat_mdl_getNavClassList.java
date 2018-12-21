package com.qishon.test;

import com.qishon.utils.UrlConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Mat_mdl_getNavClassList {

    @Test(groups = "loginTrue",description = "获取运营分类接口测试")
    public void Mat_mdl_getNavClassListTest(){
        Response response = given()
                .auth().oauth2(UrlConfig.access_token)
                .get(UrlConfig.mat_mdl_getNavClassList_url);
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
