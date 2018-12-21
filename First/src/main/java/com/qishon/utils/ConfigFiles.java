package com.qishon.utils;

import com.qishon.test.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFiles {

    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);
    public static String getUrl(InterfaceName name){
        String base_address = bundle.getString("base_url");
        String uri = "";
        if(name == InterfaceName.GETTOKEN){
            uri = bundle.getString("getToken_url");
        }
        if (name == InterfaceName.GS_SYS_SHOPLOGIN){
            uri = bundle.getString("gs_sys_shopLogin_url");
        }
        if (name == InterfaceName.GS_SYS_AMDPWD){
            uri = bundle.getString("gs_sys_amdpwd_url");
        }
        if (name == InterfaceName.MAT_MDL_GETNAVCLASSLIST){
            uri = bundle.getString("mat_mdl_getNavClassList_url");
        }
        if (name == InterfaceName.GS_SYS_GETPERSONINFOBYJOB){
            uri = bundle.getString("gs_sys_getPersoninFobyJob_url");
        }
        if (name == InterfaceName.GS_SYS_REGDEVICEINF){
            uri = bundle.getString("gs_sys_regDeviceInf_url");
        }
        if (name == InterfaceName.GS_PROD_LIST){
            uri = bundle.getString("gs_prod_list_url");
        }
        if (name == InterfaceName.GS_PROD_GETPRODINFO){
            uri = bundle.getString("gs_prod_getProdInfo_url");
        }
        if (name ==InterfaceName.GS_PROD_GETPRODORDDETAIL){
            uri = bundle.getString("gs_prod_getProdOrdDetail_url");
        }
        if (name == InterfaceName.GS_MATCH_GETFITPRODINFONEW){
            uri = bundle.getString("gs_match_getFitProdInfoNew_url");
        }
        if (name == InterfaceName.GS_MATCH_GET3DMODELINFONEW){
            uri = bundle.getString("gs_match_get3DModelInfoNew_url");
        }
        String testUrl = base_address + uri;
        return testUrl;
    }
}
