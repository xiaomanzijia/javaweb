package com.lsgx.admin.util;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 处理JSON字符串工具类
 * @author zhuangjy
 *
 */
public class JsonUtil
{
    
    public static void main(String[] args)
    {
       /* List<String> list = new ArrayList<String>();
        list.add("111");
        list.add("111");
        list.add("111");
        System.out.println(toJSON(list).toString());
        printJSON(list);
        System.out.println(toJSONString(list));
        JSONObject jo = new JSONObject();
        jo.put("name", "xiedy");
        jo.put("sex", "male");
        jo.put("age", "1");
        JSONArray ja = new JSONArray();
        ja.add(jo);
        ja.add(jo);
        JSONObject jo2 = new JSONObject();
        jo2.put("id", "1");
        jo2.put("content", ja);
        printJSON(jo2);
        System.out.println("end");*/
    }
    
    public static void printJSON(Object obj)
    {
        System.out.println("===json====");
        Object json = toJSON(obj);
        if (json instanceof JSONArray)
        {
            System.out.println(((JSONArray)json).toString(4));
        }
        else if (json instanceof JSONObject)
        {
            System.out.println(((JSONObject)json).toString(4));
        }
        else
        {
            if (json == null)
            {
                System.out.println("null");
            }
            else
            {
                System.out.println(json.toString());
            }
        }
        System.out.println("===json====");
    }
    
    public static Object toJSON(Object obj)
    {
        Object tmp = null;
        //基本数据类型则直接返回
        if (isBasicType(obj))
        {
            return obj;
        }
        if ((obj instanceof List) || (obj.getClass().isArray()))
        {
            JSONArray ja = JSONArray.fromObject(obj);
            tmp = ja;
        }
        else
        {
            JSONObject jobject = JSONObject.fromObject(obj);
            tmp = jobject;
        }
        return tmp;
    }
    
    private static boolean isBasicType(Object obj)
    {
        if (obj == null)
        {
            return true;
        }
        //字符串
        if ((obj instanceof String) || (obj instanceof Character))
        {
            return true;
        }
        //数字
        if (obj instanceof Number)
        {
            return true;
        }
        if (obj instanceof Boolean)
        {
            return true;
        }
        return false;
    }
    
    public static String toJSONString(Object obj)
    {
        Object json = toJSON(obj);
        if (json == null)
        {
            return "null";
        }
        else
        {
            return json.toString();
        }
    }
    
    public static Object getObject4JsonString(String jsonString, Class pojoCalss)
    {
        
        Object pojo;
        
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        
        pojo = JSONObject.toBean(jsonObject, pojoCalss);
        
        return pojo;
        
    }
    
    public static List getList4Json(String jsonString, Class pojoClass)
    {
        
        JSONArray jsonArray = JSONArray.fromObject(jsonString);
        
        JSONObject jsonObject;
        
        Object pojoValue;
        
        List list = new ArrayList();
        
        for (int i = 0; i < jsonArray.size(); i++)
        {
            
            jsonObject = jsonArray.getJSONObject(i);
            
            pojoValue = JSONObject.toBean(jsonObject, pojoClass);
            
            list.add(pojoValue);
            
        }
        
        return list;
        
    }
    
    public static Object[] getObjectArray4Json(String jsonString)
    {
        
        JSONArray jsonArray = JSONArray.fromObject(jsonString);
        
        return jsonArray.toArray();
        
    }
    /**
     * json数据转化成list数组
     * @param json
     * @return
     */
    public static List<String> jsonToList(String json){
    	String[] temp = json.split(",");
    	List<String> list = new ArrayList<String>();
    	for(int i=0;i<temp.length;i++){
			String str = temp[i].split(":")[1].replaceAll("\"", "");
			str = str.replaceAll("}", "");
			list.add(str);
		}
    	return list;
    }

}

