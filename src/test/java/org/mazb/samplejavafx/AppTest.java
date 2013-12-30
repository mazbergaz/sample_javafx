package org.mazb.samplejavafx;

import java.util.Date;
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
        u.setCreatedOn(new Date());
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
        assertTrue(res.equals("{\"id\":8,\"userName\":\"username\","
                + "\"realName\":\"real\",\"email\":\"em@i.l\","
                + "\"password\":\"pass\",\"createdOn\":"+u.getCreatedOn().getTime()+","
                + "\"lastModified\":null}"));
        
        assertTrue(u.equals(CommonParser.parseJsonToObject(res, User.class)));
        
        res = CommonParser.parseToQueryString(u);
        assertTrue(res.equals("id=8&userName=username&realName=real"
                + "&email=em@i.l&password=pass&createdOn="+u.getCreatedOn().getTime()));
        
        System.out.println(CommonParser.parseToQueryString(new User("abc", "abc123")));
        
    }
    
    @Test
    public void testHttpConnection(){
        Object obj = restClient.postFormData(new User("mazbergaz", "bergas123"), CommonConstant.RestOperationPath.VALIDATE_USER);
        assertTrue(obj!=null && obj instanceof User && ((User)obj).getUserName().equals("mazbergaz"));
        Object obj2 = restClient.postFormData(new User("mazbergaz", "bergas13"), CommonConstant.RestOperationPath.VALIDATE_USER);
        assertTrue(obj2==null);
    }
    
}
