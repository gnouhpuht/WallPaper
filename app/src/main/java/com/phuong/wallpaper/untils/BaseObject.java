package com.phuong.wallpaper.untils;

import org.json.JSONArray;
import org.json.JSONObject;

public class BaseObject {
    public String getStringFromJSON(String key, JSONObject object){
        String result = "";
        try{
            if (object.has(key) && !object.isNull(key)){
                result = object.getString(key);
            }
        }
        catch (Exception e){
            Utils.error(e.getMessage());
            result = "";
        }
        finally {
            return result;
        }
    }

    public boolean getBoolFromJSON(String key, JSONObject object){
        boolean result = false;
        try{
            if (object.has(key) && !object.isNull(key)){
                result = object.getBoolean(key);
            }
        }
        catch (Exception e){
            Utils.error(e.getMessage());
            result = false;
        }
        finally {
            return result;
        }
    }

    public static JSONObject getJSONFromJSON(String key, JSONObject object){
        JSONObject result = null;
        try{
            if (object.has(key) && !object.isNull(key)){
                Object tmpObject = object.get(key);
                if (tmpObject instanceof JSONObject){
                    result = (JSONObject) tmpObject;
                }
            }
        }
        catch (Exception e){
            Utils.error(e.getMessage());
            result = null;
        }
        finally {
            if (result == null){
                result = new JSONObject();
            }
            return result;
        }
    }

    public static JSONArray getJSONArrayFromJSON(String key, JSONObject object){
        JSONArray result = null;
        try{
            if (object.has(key) && !object.isNull(key)){
                result = object.getJSONArray(key);
            }
        }
        catch (Exception e){
            Utils.error(e.getMessage());
            result = null;
        }
        finally {
            return result;
        }
    }

    public int getIntFromJSON(String key, JSONObject object){
        int result = 0;
        try{
            if (object.has(key) && !object.isNull(key)){
                result = object.getInt(key);
            }
        }
        catch (Exception e){
            Utils.error(e.getMessage());
            result = 0;
        }
        finally {
            return result;
        }
    }

    public int getIntFromJSONDefault(String key, JSONObject object){
        int result = -1;
        try{
            if (object.has(key) && !object.isNull(key)){
                result = object.getInt(key);
            }
        }
        catch (Exception e){
            Utils.error(e.getMessage());
            result = -1;
        }
        finally {
            return result;
        }
    }

    public double getDoubleFromJSON(String key, JSONObject object){
        double result = 0;
        try{
            if (object.has(key) && !object.isNull(key)){
                result = object.getDouble(key);
            }
        }
        catch (Exception e){
            Utils.error(e.getMessage());
            result = 0;
        }
        finally {
            return result;
        }
    }

    public static JSONObject getJSONObjectInJSONArrayAtIndex(int index, JSONArray array){
        JSONObject result = null;
        try{
            result = array.getJSONObject(index);
        }
        catch (Exception e){
            Utils.error(e.getMessage());
            result = null;
        }
        finally {
            return result;
        }
    }

    public static String getStringInJSONArrayAtIndex(int index, JSONArray array){
        String result = "";
        try{
            result = array.getString(index);
        }
        catch (Exception e){
            Utils.error(e.getMessage());

        }

        return result;
    }

    public JSONObject getJSONObjectFromJSON(String key, JSONObject object){
        JSONObject result = null;
        try{
            if (object.has(key) && !object.isNull(key)){
                Object tmpObject = object.get(key);
                if (tmpObject instanceof JSONObject){
                    result = (JSONObject) tmpObject;
                }
            }
        }
        catch (Exception e){
            Utils.error(e.getMessage());
            result = null;
        }
        finally {
            if (result == null){
                result = new JSONObject();
            }
            return result;
        }
    }

}
