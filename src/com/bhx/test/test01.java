package com.bhx.test;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class test01 {

    /**
     * @param args
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException

     */
    public static void main(String[] args) throws Exception{

        Map<String, Integer> sourceCountMap = new HashMap();//正确或错误的题数
        sourceCountMap.put("借款用途",1);
        sourceCountMap.put("联系人信息",3);
        sourceCountMap.put("借款确认",1);
        sourceCountMap.put("身份核实",2);
        String text ="{\"dimension\":[\"单位信息\",\"联系人信息\",\"借款确认\",\"身份核实\"],\"errorNum\":3,\"type\":2}";
        JSONObject contentJson = JSONObject.parseObject(text);

        int errorNumsource =0;
        int errorNumConfig = contentJson.getIntValue("errorNum");//配置的错题总数
        JSONArray dimensionArr = contentJson.getJSONArray("dimension");//所配置的维度类型
        for (int i = 0; i < dimensionArr.size(); i++) {
            if (sourceCountMap.containsKey(dimensionArr.getString(i))){//主观题可能不包含
                errorNumsource += sourceCountMap.get(dimensionArr.getString(i));
            }
        }
        System.out.println("errorNumsource:"+errorNumsource+" errorNumConfig:"+errorNumConfig);
        System.out.println(isMatchCond(errorNumsource,errorNumConfig,2));
    }


    /**
     * @param source 源数值
     * @param target 目标数值
     * @param operators 操作符，判断符号，1:大于,2:大于等于,3:小于,4:小于等于
     * @return
     */
    private static   boolean isMatchCond(Integer source,Integer target,Integer operators){
        source=source==null?0:source;
        if(target==null){//如果目标数值为null，说明不需要验证，直接返回true
            return true;
        }
        if(operators==null){
            return false;
        }
        if(operators==1){
            return source>target;
        }else if(operators==2){
            return source>=target;
        }else if(operators==3){
            return source<target;
        }else if(operators==4){
            return source<=target;
        }
        return false;
    }
}

