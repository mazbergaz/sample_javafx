package org.mazb.samplejavafx;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import org.junit.Test;
import org.mazb.samplejavafx.common.CommonConstant;
import org.mazb.samplejavafx.common.CommonParser;
import org.mazb.samplejavafx.model.User;
import org.mazb.samplejavafx.util.RestClient;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    
    private RestClient restClient = new RestClient();
    
    private User getUser(){
        User u = new User();
        u.setId(8);
        u.setCreatedOn(new Date().getTime());
        u.setEmail("em@i.l");
        u.setPassword("pass");
        u.setRealName("real");
        u.setUserName("username");
        return u;
    }
    
    @Test
    public void testJsonParser(){
        User u = getUser();
        
        String res = CommonParser.parseToJson(u);
        assertTrue(res.equals("{\"id\":8,\"userName\":\"username\""
                + ",\"realName\":\"real\",\"password\":\"pass\""
                + ",\"email\":\"em@i.l\",\"roleDto\":null"
                + ",\"createdBy\":null,\"createdOn\":"+u.getCreatedOn()
                + ",\"modifiedBy\":null,\"lastModified\":0}"));
        assertTrue(u.equals(CommonParser.parseJsonToObject(res, User.class)));
        
        res = CommonParser.parseToQueryString(u);
        assertTrue(res.equals("id=8&userName=username&realName=real"
                + "&password=pass&email=em@i.l&createdOn="+u.getCreatedOn()));
        
    }
    
    @Test
    public void testHttpConnection(){
        if(restClient.isConnectionOk()){
            Object obj = restClient.postFormData(new User("mazbergaz", "bergas123"), CommonConstant.RestOperationPath.VALIDATE_USER);
            assertTrue(obj!=null && obj instanceof User && ((User)obj).getUserName().equals("mazbergaz"));
            Object obj2 = restClient.postFormData(new User("mazbergaz", "bergas13"), CommonConstant.RestOperationPath.VALIDATE_USER);
            assertTrue(obj2==null);
        }else{
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "there's no connection to server. skip test.");
        }
    }
    
}
