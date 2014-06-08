package org.mazb.samplejavafx;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.mazb.samplejavafx.common.CommonConstant;
import org.mazb.samplejavafx.common.CommonParser;
import org.mazb.samplejavafx.model.Menu;
import org.mazb.samplejavafx.model.Menus;
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
    public void testJsonPropertiesReader(){
        String fileLoc = getClass().getResource("/setup/menu.json").getFile();
        Menus menus = (Menus) CommonParser.parseJsonToObject(new File(fileLoc), Menus.class);
        assertTrue(StringUtils.equals(menus.getMenus().get(1).getTitle(), "User"));
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
