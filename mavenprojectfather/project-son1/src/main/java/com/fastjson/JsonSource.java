package com.fastjson;

public class JsonSource {

    /**
     * json字符串-简单类型
     */
    public static final String JSON_OBJ_STR = "{\"studentName\":\"zhangsan\",\"studentAge\":15}";

    /**
     * json字符串-数字类型
     */
    public static final String JSON_ARRAY_STR = "[{\"studentName\":\"学生1\",\"studentAge\":15},{\"studentName\":\"学生2\",\"studentAge\":20}]";

    /**
     * json字符串-复杂类型
     */
    public static final String JSON_COMPLEX_STR = "{\"teacherName\":\"李老师\",\"teacherAge\":\"25\",\"course\":{\"courseName\":\"english\",\"courseCode\":\"10001\"},\"student\":[{\"studentName\":\"学生1\",\"studentAge\":15},{\"studentName\":\"学生2\",\"studentAge\":20}]}";
}
