package com.fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import javax.sql.DataSource;

public class FastJson {
    public static void main(String[] args) {
        JSONObject obj = JSONObject.parseObject(JsonSource.JSON_OBJ_STR);
        System.out.println(obj.getString("studentName"));
        System.out.println(obj.getInteger("studentAge"));

        JSONArray array = JSONArray.parseArray(JsonSource.JSON_ARRAY_STR);
        for(int i = 0; i < array.size(); i++) {
            JSONObject obj1 = array.getJSONObject(i);
            System.out.println(obj1.getString("studentName"));
            System.out.println(obj1.getInteger("studentAge"));
        }

        Teacher obj2 = JSONObject.parseObject(JsonSource.JSON_COMPLEX_STR, Teacher.class);
        System.out.println(obj2.getTeacherName());
        Teacher t = JSONObject.parseObject(JsonSource.JSON_COMPLEX_STR, new TypeReference<Teacher>(){});
        System.out.println(t);
    }
}
