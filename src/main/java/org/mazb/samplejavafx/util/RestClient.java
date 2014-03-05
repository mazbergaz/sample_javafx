package org.mazb.samplejavafx.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mazb.samplejavafx.common.CommonParser;

/**
 * @author mazbergaz@gmail.com
 */
public class RestClient {
    
    private static final String BASE_URL = "http://dev.mazbergaz.org:9090/sampleserver";
    private static final Logger LOGGER = Logger.getLogger(RestClient.class.getName());
    
    /**
     * parse object to Json and send post request, return object (parsed from http response)
     * @param obj
     * @param operationPath can be retrieved from CommonConstant.RestOperationPath.*
     * @return 
     */
    public Object postJsonData(Object obj, String operationPath){
        String response = post(CommonParser.parseToJson(obj), operationPath);
        return response==null ? null : CommonParser.parseJsonToObject(response, obj.getClass());
    }
    
    /**
     * parse object to form query string and send post request, return object (parsed from http response)
     * @param obj
     * @param operationPath can be retrieved from CommonConstant.RestOperationPath.*
     * @return 
     */
    public Object postFormData(Object obj, String operationPath){
        String response = post(CommonParser.parseToQueryString(obj), operationPath);
        return response==null ? null : CommonParser.parseJsonToObject(response, obj.getClass());
    }
    
    private String post(String content, String operationPath){
        String result = null;
        int responseCode = 0;
        try {
            URL obj = new URL(BASE_URL+operationPath);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            
            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(content);
            wr.flush();
            wr.close();
            
            responseCode = con.getResponseCode();

            if(responseCode<300){
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                
                result = response.toString();
            }

        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        
        LOGGER.log(Level.INFO, "http status ="+responseCode+", response = "+result);
        
        return result;
    }
    
    public Object get(Object object){
        Object result = null;
        
        return result;
    }
    
}
