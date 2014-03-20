
/**
 * PriceHandler Class
 * 
 * This class handles the price data
 * 
 * @author Marc Reinhardt
 * @version 0.1
 */

package SmartMeter;
import Server.*;

public class PriceHandler
{
    private double price;
    private double gprice;
    ConnectionHandler conHandler;

    /**
     * PriceHandler Constructor
     *
     * @param s A parameter
     */
    public PriceHandler(ServerSocket s){
        conHandler = new ConnectionHandler(s);
    }

    /**
     * Method initPriceHandler
     *
     */
    public void initPriceHandler(){
        price = 0.11;
        gprice = 0.8;
    }
    
    /**
     * updatePrice
     * updates provider priceinformation
     */               
    public void updatePrice()
    {
        try{
            price = conHandler.openSocketPrice();
        }catch (InvalidSignException i){
            System.out.println("An Error has occoured. Error 666. Please call Paddy.");
        }
        return;
    }
    
    /**
     * Method updategPrice
     * get price from external server via connection handler
     */
    public void updategPrice()
    {
        try{
            gprice = conHandler.openSocketgPrice();
        }catch (InvalidSignException i){
            System.out.println("An Error has occoured. Error 666. Please call Paddy.");
        }
        return;
    }

    /**
     * getPrice
     * get the current price stored in the smart meter
     */               
    public double getPrice()
    {
        return price;
    }
    
    /**
     * Method getgPrice
     * get the current price stored in the smart meter
     */
    public double getgPrice()
    {
        return gprice;
    }

}
