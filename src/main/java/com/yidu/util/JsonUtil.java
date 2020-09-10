package com.yidu.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.yidu.systemManage.pojo.RolePojo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 把json字符串转换为实体类对象的工具类
 */
public class JsonUtil {
    /**
     *
     * @param json json字符串
     * @param bean 实体类的class类对象
     * @param <T>
     * @return 实体类对象的集合
     */
    public static<T> List<T> jsonToArrayList(String json,Class<T> bean){
        //得到json对象类型
        Type type = new TypeToken<ArrayList<JsonObject>>() {
        }.getType();
        //转换为json数组
        ArrayList<JsonObject> jsonObjectList = new Gson().fromJson(json,type);
        ArrayList<T> arrayList = new ArrayList<T>();
        //把json数组转换为实体类对象 放入arrayList集合中
        for (JsonObject jsonObject : jsonObjectList) {
            arrayList.add(new Gson().fromJson(jsonObject,bean));
        }
        //返回实体类对象的集合
        return arrayList;
    }

}
