/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mazb.samplejavafx.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bergasbimo
 */
public class FileHandler {
    
    private static final boolean APPEND = true;
    private static final String RESULT_FOLDER = "/Users/bergasbimo/Documents/workspace/jfx_sampleresult/";
    
    public boolean writeFile(String content, String menu){
        boolean result = false;
        BufferedWriter output = null;
        String folder;
        try {
            folder = getActualFolderPath(RESULT_FOLDER + menu + "/");
            output = new BufferedWriter(new FileWriter(folder + menu + ".unaploaded", APPEND));
            output.append(content);
            output.newLine();
            result = true;
        } catch (Exception ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(output != null) output.close();
            } catch (IOException ex) {
                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    private String getActualFolderPath(String folder) throws FileNotFoundException{
        File file = new File(folder);
        boolean success = file.exists() ? true : file.mkdirs();
        if(!success){
            throw new FileNotFoundException();
        }
        return folder;
    }
    
}
