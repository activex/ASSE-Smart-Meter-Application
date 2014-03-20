/**
 * ServerSocket Class
 * This implements the connection to the remote server of the utility provider to receive
 * usage data and update the current price
 * 
 * @author Marc Reinhardt
 * @version 0.2
 */

package Server;

public class ServerSocket
{   
    private  SignedPrice price;
    private  SignedgPrice gprice;
   
    
    
    /**
     * ServerSocket Constructor
     * Creates Prices for used and generated power and adds a server signature to it.
     */
    public ServerSocket(){
    price = new SignedPrice(5,0.14);
    gprice = new SignedgPrice(5,0.09);
    }
    

    /**
     * Method signatureTest - TEST PURPOSE
     * Adds invalid data and invalid signature to the prices to test receiving data from
     * an unauthorisised server
     */
    public void signatureTest(){
    price = new SignedPrice(99,0.14);
    gprice = new SignedgPrice(99,0.09);
    }
    
    /**
     * Method updatePrice
     * Returns the price for used power
     */
    public  SignedPrice updatePrice(){
        return price;
    }
    
    /**
     * Method updategPrice
     * Returns the price for generated power
     */
    public  SignedgPrice updategPrice(){
        return gprice;
    }

     /**
     * updateUsage
     * Simulates the provider side usage storage
     */
    public  void updateUsage(String CID, double usage){
        
        return;
    }
    public  void updateUsage(String dummy){
        
        return;
    }
    
    /**
     * updateGenerated
     * Simulates the provider side generated KWH storage
     */
    public  void updateGenerated(String CID, double generated){
        
        return;
    }
    public  void updateGenerated(String dummy){
        
        return;
    }
    
}
