/**
 * ConnectionHandler Class
 * This class is used by the smart meter to control connections from the outside, i.e. with the utitlity provider
 * 
 * @author Marc Reinhardt
 * @version 0.1
 */

package SmartMeter;

import java.util.*;
import java.io.*;
import Server.*;
import AuxDevice.*;
import SmartAppliance.*;

public class ConnectionHandler
{
    //ServerSocket ssocket;
    
    ServerSocket ss;
    AuxDevice aux;
    SmartApp app;
    
    /**
     * ConnectionHandler Constructor
     *
     * @param s A parameter
     */
    public ConnectionHandler(ServerSocket s){
        ss  = s;

    }
    
    /**
     * ConnectionHandler Constructor
     *
     * @param s A parameter
     * @param a A parameter
     */
    public ConnectionHandler(ServerSocket s, AuxDevice a){
        ss  = s;
        aux = a;

    }
    
    /**
     * ConnectionHandler Constructor
     *
     * @param a A parameter
     */
    public ConnectionHandler(SmartApp a){
        app = a;
    }
    
    /**
     * openSocketPrice
     * Simulates a connection to a server to update the price.
     * The method calls the dummy cryptsign class to veryfiy the signature
     * of the received price
     */
    public double openSocketPrice() throws InvalidSignException{
        SignedPrice price = ss.updatePrice();
        
        if(Cryptsign.checksign(price)){
            return price.getPrice();
        }
        else{
            throw new InvalidSignException();
        }
    }
    
     /**
     * openSocketgPrice
     * Simulates a connection to a server to update the price.
     * The method calls the dummy cryptsign class to veryfiy the signature
     * of the received price
     */
    public double openSocketgPrice() throws InvalidSignException{
        SignedgPrice price = ss.updategPrice();
        
        if(Cryptsign.checksign(price)){
            return price.getPrice();
        }
        else{
            throw new InvalidSignException();
        }
    }
    
    /**
     * openSocketUsage
     * Simulates a connection to a server to send the usage.
     * The method calls the dummy cryptsign class to crypt and sign
     * the usage send
     */
    public void openSocketUsage(String CID, String usage){
        ss.updateUsage(Cryptsign.sign(Cryptsign.encrypt(CID, usage))); 
    }
    /*
     /**
     * openSocketGenerated
     * Simulates a connection to a server to send the generated KWH.
     * The method calls the dummy cryptsign class to crypt and sign
     * the usage send
     *
    public void openSocketGenerated(String CID, double generated){
        ServerSocket.updateGenerated(Cryptsign.sign(Cryptsign.encrypt(CID, generated))); 
    }
   */
    /**
     * openInterfaceAuxDevice
     */
    public double openInterfaceAuxDevice() throws InvalidSignException{
        SignedGenerated gen = aux.updateGenerated();
        
        if(Cryptsign.checksign(gen)){
          return gen.getGenerated();
        }
        else{
            throw new InvalidSignException();
        }
    }
    
     /**
     * openInterfaceSmartApp
     */
    public String openInterfaceSmartApp() throws InvalidSignException{
        SignedCom com = app.updateCom();
        
        if(Cryptsign.checksign(com)){
          return com.getCom();
        }
        else{
            throw new InvalidSignException();
        }
    }
}
