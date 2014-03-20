
/**
 * FileHandler Class
 * Reads in Command File and passes valid command to the smartmeter engine
 */

package SmartMeter;

import java.util.*;
import java.io.*;
import java.util.Scanner;

public class FileHandler
{

    File file;
    
    /**
     * FileHandler Constructor
     *
     */
    public FileHandler(){
        file = new File();
    }
    

    /**
     * writeUsage
     * 
     */
    public void writeUsage(double n){
        
        file.setFile(Cryptsign.sign(Cryptsign.encrypt("DATA", "22")));
        
        return;
    }
    
    /**
     * writeGenerated
     * 
     */
    public void writeGenerated(double n){  
        
        file.setFile(Cryptsign.sign(Cryptsign.encrypt("DATA", "22")));
        
        return;
    }

    /**
     * getUsage
     * 
     */
    public String getUsage() throws InvalidSignException{     
        
        if(Cryptsign.checksign(file.getSig())){
            return file.getFile();
        }
        else{
           throw new InvalidSignException();
        }
        
    }
    
     /**
     * getGenerated
     * 
     */
    public String getGenerated() throws InvalidSignException{
        if(Cryptsign.checksign(file.getSig())){
            return file.getFile();
        }
        else{
           throw new InvalidSignException();
        }


    }
    
}
