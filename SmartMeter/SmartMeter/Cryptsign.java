
/**
 * Cryptsign
 * 
 * Cryptsign is a dummy class to implement de/encryption as well as signange and signature checking
 * 
 * @author Marc Reinhardt
 * @version 0.1
 */

package SmartMeter;
import Server.*;
import AuxDevice.*;
import SmartAppliance.*;
import java.util.*;

public class Cryptsign
{
    /**
     * decrypt
     * Dummy method for crypto
     */
    public static double decrypt(double n){     
        return n;
    }
    
     /**
     * encrypt
     * Dummy method for crypto
     */
    public static String encrypt(String n, String a){     
        Date timestamp = new Date();
        // add timestamp -> encrypt
        return n;
    }

    /**
     * sign
     * Dummy method for sign
     */
    public static double sign(double n){
        Date timestamp = new Date();
        // add timestamp -> sign
        return n;
    }
    public static String sign(String n){
        Date timestamp = new Date();
        // add timestamp -> sign
        return n;
    }
    
     /**
     * checksign
     * Dummy method for signature checking
     */
    public static boolean checksign(SignedPrice n){
        
        if(n.getSig() == 5 || n.getSig() == 6){
            return true;
        }else{
            return false;
        }
    }
    public static boolean checksign(int n){
        
        if(n == 4){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Method checksign
     *
     * @param n A parameter
     * @return The return value
     */
    public static boolean checksign(SignedgPrice n){
        
        if(n.getSig() == 5){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Method checksign
     *
     * @param n A parameter
     * @return The return value
     */
    public static boolean checksign(SignedGenerated n){
        
        if(n.getSig() == 6){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Method checksign
     *
     * @param n A parameter
     * @return The return value
     */
    public static boolean checksign(SignedCom n){
        
        if(n.getSig() == 6){
            return true;
        }else{
            return false;
        }
    }
}