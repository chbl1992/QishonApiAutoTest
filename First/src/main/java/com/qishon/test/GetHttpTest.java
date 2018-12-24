package com.qishon.test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

@Ignore
public class GetHttpTest {

    @Test
    public void getTest(){
        Response response = given()
                .get("https://www.baidu.com");
        response.prettyPrint();
    }

    @Test
    public void getHttpsTest(){
        Response response = given()
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                .params("q","自动化测试","start","0","count",2)
                .get("https://api.douban.com/v2/book/search");
        //response.prettyPrint();

        Map cookies = response.getCookies();
        System.out.println();

        Headers headers = response.getHeaders();

        String contenType = response.getContentType();
        System.out.println(contenType);
    }

    @Test
    public void postTest(){

        Response response = given()
                .body("{\"platform\":\"DGP\",\"password\":\"123456\",\"username\":\"QS001\",\"domainUrl\":\"qsxls.iss.com:8088\",\"client_id\":\"u3dIssClient\",\"client_secret\":\"u3dIssClientSecret\"}}")
                .contentType("application/json")
                .headers("Accept", "*/*", "ownCompanyId", "239")
                .post("http://qishon-zuul-gateway.test.qishon.com/uaa/oauth-pwd/token");
        response.prettyPrint();
    }

}
