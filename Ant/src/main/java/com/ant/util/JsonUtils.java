package com.ant.util;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * <p>
 * Created by doublehuang.
 */

public class JsonUtils {

    public static String toJsonString(Map<String,Object> map){
        return new JSONObject(map).toJSONString();
    }

}
