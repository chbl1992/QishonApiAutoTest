package com.qishon.test;

import com.qishon.utils.ConfigFiles;
import com.qishon.utils.UrlConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginTest {

    @BeforeTest(groups = "LoginTrue",description = "登陆前获取url")
    public void beforeTest_url(){
        UrlConfig.getToken_url = ConfigFiles.getUrl(InterfaceName.GETTOKEN);
        UrlConfig.gs_sys_shopLogin_url = ConfigFiles.getUrl(InterfaceName.GS_SYS_SHOPLOGIN);
        UrlConfig.gs_sys_amdpwd_url = ConfigFiles.getUrl(InterfaceName.GS_SYS_AMDPWD);
        UrlConfig.mat_mdl_getNavClassList_url = ConfigFiles.getUrl(InterfaceName.MAT_MDL_GETNAVCLASSLIST);
        UrlConfig.gs_sys_getPersoninFobyJob_url = ConfigFiles.getUrl(InterfaceName.GS_SYS_GETPERSONINFOBYJOB);
        UrlConfig.gs_sys_regDeviceInf_url = ConfigFiles.getUrl(InterfaceName.GS_SYS_REGDEVICEINF);
        UrlConfig.gs_prod_list_url = ConfigFiles.getUrl(InterfaceName.GS_PROD_LIST);
        UrlConfig.gs_prod_getProdInfo_url = ConfigFiles.getUrl(InterfaceName.GS_PROD_GETPRODINFO);
        UrlConfig.gs_prod_getProdOrdDetail_url = ConfigFiles.getUrl(InterfaceName.GS_PROD_GETPRODORDDETAIL);
        UrlConfig.gs_match_getFitProdInfoNew_url = ConfigFiles.getUrl(InterfaceName.GS_MATCH_GETFITPRODINFONEW);
        UrlConfig.gs_match_get3DModelInfoNew_url = ConfigFiles.getUrl(InterfaceName.GS_MATCH_GET3DMODELINFONEW);

    }

    @Test(groups = "LoginTrue",description = "获取Token")
    public void getToken(){
        Response response = given()
                .contentType("application/json")
                //.header("Accept", "*/*")
                .body("{\"platform\":\"DGP\",\"password\":\"123456\",\"username\":\"QS003\",\"domainUrl\":\"qsxls.iss.com:8088\",\"client_id\":\"u3dIssClient\",\"client_secret\":\"u3dIssClientSecret\"}")
                .post(UrlConfig.getToken_url);
        //response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
        response.prettyPrint();
        UrlConfig.access_token = response.jsonPath().getString("access_token");
    }

    @Test(dependsOnMethods = "getToken",groups = "loginTrue",description = "店铺登陆接口测试",priority = 1)
    public void gs_sys_shopLogin(){
        Response response = given()
                .contentType("application/json")
                .auth().oauth2(UrlConfig.access_token )
                .body("{\"usrKey\":null,\"shopCode\":\"QS0001\",\"deviceCode\":\"C85B76DB6828\",\"brandCode\":null,\"usrName\":\"QS003\",\"loginPwd\":\"E10ADC3949BA59ABBE56E057F20F883E\",\"jobType\":\"D_SHOPGUIDER\",\"languageCode\":\"zh-CN\",\"address\":null,\"provinceCode\":null,\"cityCode\":null,\"districtCode\":null,\"deviceType\":\"D_DIPAD\",\"pwdFlag\":\"1\"}")
                .post(UrlConfig.gs_sys_shopLogin_url);
        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }

    @Test(dependsOnMethods = "getToken",groups = "loginTrue",description = "修改密码接口测试",priority = 2)
    public void alter_PWD(){
        Response response = given()
                .contentType("application/json")
                .auth().oauth2(UrlConfig.access_token)
                .body("{\"oldPwd\":\"123456\",\"newPwd\":\"654321\",\"usrName\":\"QS003\",\"jobType\":\"D_SHOPGUIDER\"}")
                .put(UrlConfig.gs_sys_amdpwd_url);
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }
}
