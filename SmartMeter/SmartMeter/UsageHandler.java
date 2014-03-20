
/**
 * UsageHandler Class.
 * 
 * This Class deals with the usage data
 * 
 * @author Marc Reinhardt
 * @version 0.1
 */

package SmartMeter;
import Server.*;

public class UsageHandler
{
    ConnectionHandler conHandler;
    FileHandler fileHandler;

     /**
      * UsageHandler Constructor
      */
     public UsageHandler(ServerSocket s){
         conHandler = new ConnectionHandler(s);
         fileHandler = new FileHandler();
     }

    /**
     * saveUsage
     * saves usage information in smart meter
     */               
    public void saveUsage()
    {
        fileHandler.writeUsage(1234.56);
        return;
    }
    
    /**
     * updateUsage
     * sends usage information to provider
     */               
    public void updateUsage(String CID)
    {
        try{
            conHandler.openSocketUsage(CID, fileHandler.getUsage());
        }catch (InvalidSignException i){
            System.out.println("An Error has occoured. Error 666. Please call Paddy.");
        }
        return;
    }
    
    public void getFileUsage()
    {
        try{
            String a = fileHandler.getUsage();
        }catch (InvalidSignException i){
            System.out.println("An Error has occoured. Error 666. Please call Paddy.");
        }

        
    }
    
}
