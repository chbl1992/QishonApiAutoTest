package com.qishon.test;

import com.qishon.utils.UrlConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Gs_match_get3DModelInfoNew {

    @Test(groups = "LoginTrue",description = "定制渲染接口测试")
    public void Gs_match_get3DModelInfoNewTest(){
        Response response = given()
                .contentType("application/json")
                .auth().oauth2(UrlConfig.access_token)
                .body("{\"prodCode\":\"QZJ001\",\"mainFabricCode\":null,\"prodPartSet\":[{\"regionId\":\"66\"," +
                        "\"regionCode\":\"D_POCKET\",\"partId\":\"530\",\"partCode\":\"J_11_PCCA_F\"," +
                        "\"fabricId\":\"597\",\"fabricCode\":\"QS1010152\",\"salePrice\":null,\"regionName\":\"腰兜\"," +
                        "\"partName\":\"J_11_PCCA_F\"},{\"regionId\":\"67\",\"regionCode\":\"D_COLLA\"," +
                        "\"partId\":\"513\",\"partCode\":\"J_32_COLL_PL_C\",\"fabricId\":\"597\"," +
                        "\"fabricCode\":\"QS1010152\",\"salePrice\":null,\"regionName\":\"领型\"," +
                        "\"partName\":\"J_32_COLL_PL_C\"},{\"regionId\":\"71\",\"regionCode\":\"D_BACK_PIECE\"," +
                        "\"partId\":\"468\",\"partCode\":\"J_BACK_C\",\"fabricId\":\"597\",\"fabricCode\":\"QS1010152\"," +
                        "\"salePrice\":null,\"regionName\":\"后片\",\"partName\":\"J_BACK_C\"}," +
                        "{\"regionId\":\"72\",\"regionCode\":\"D_BREAST_POCKET\",\"partId\":\"476\"," +
                        "\"partCode\":\"J_11_PCBR_C\",\"fabricId\":\"597\",\"fabricCode\":\"QS1010152\"," +
                        "\"salePrice\":null,\"regionName\":\"胸兜\",\"partName\":\"J_11_PCBR_C\"}," +
                        "{\"regionId\":\"73\",\"regionCode\":\"D_FRONT_PIECE\",\"partId\":\"516\"," +
                        "\"partCode\":\"J_32_FRON_LC\",\"fabricId\":\"597\",\"fabricCode\":\"QS1010152\"," +
                        "\"salePrice\":null,\"regionName\":\"前片\",\"partName\":\"J_32_FRON_LC\"}," +
                        "{\"regionId\":\"74\",\"regionCode\":\"D_SLEEVE_BUTTON\",\"partId\":\"547\"," +
                        "\"partCode\":\"J_SLBU_5B\",\"fabricId\":\"597\",\"fabricCode\":\"QS1010152\"," +
                        "\"salePrice\":null,\"regionName\":\"袖扣\",\"partName\":\"J_SLBU_5B\"}," +
                        "{\"regionId\":\"75\",\"regionCode\":\"D_SLEEVE_VENT\",\"partId\":\"549\"," +
                        "\"partCode\":\"J_SLEE_B\",\"fabricId\":\"597\",\"fabricCode\":\"QS1010152\"," +
                        "\"salePrice\":null,\"regionName\":\"袖开衩\",\"partName\":\"J_SLEE_B\"}]," +
                        "\"platformType\":\"D_MAT_PC\",\"needEnv\":null,\"needModel\":null}")
                .post(UrlConfig.gs_match_get3DModelInfoNew_url);
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
