package org.mazb.samplejavafx.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.mazb.samplejavafx.util.RestClient;

/**
 * @author mazbergaz@gmail.com
 */
public class JsonParser {
    
    private static ObjectMapper mapper = new ObjectMapper();
    
    public static Object parseJsonToObject(File jsonFile, Class cls){
        Object result = null;
        try {
            result = mapper.readValue(jsonFile, cls);
        } catch (IOException ex) {
            Logger.getLogger(JsonParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static Object parseJsonToObject(String json, Class cls){
        Object result = null;
        try {
            result = mapper.readValue(json, cls);
        } catch (IOException ex) {
            Logger.getLogger(JsonParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static String parseToJson(Object obj){
        String result = null;
        try {
            result = mapper.writeValueAsString(obj);
        } catch (IOException ex) {
            Logger.getLogger(JsonParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static String parseToQueryString(Object obj){
        StringBuffer strbuf = new StringBuffer();
        Field[] fields = obj.getClass().getDeclaredFields();
        for(int i=0; i<fields.length; i++){
            Field field = fields[i];
            field.setAccessible(true);
            try {
                Object val = field.get(obj);
                if(val!=null){
                    if(val instanceof Date){
                        val = ((Date)val).getTime();
                    }
                    if(!((val instanceof Long && ((Long)val).longValue()==0) || (val instanceof Integer && ((Integer)val).intValue()==0))){
                        strbuf.append(i>0 && !strbuf.toString().isEmpty() ? "&" : "");
                        strbuf.append(field.getName());
                        strbuf.append("=");
                        strbuf.append(val);
                    }
                }
                
            } catch (Exception ex) {
                Logger.getLogger(RestClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return strbuf.toString();
    }
    
}
