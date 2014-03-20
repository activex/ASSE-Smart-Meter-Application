
/**
 * GeneratedHandler Class.
 * 
 * This Class deals with the usage data
 * 
 * @author Marc Reinhardt
 * @version 0.1
 */

package SmartMeter;
import Server.*;
import AuxDevice.*;

public class GeneratedHandler
{
    private double gen;
    ConnectionHandler conHandler;
    FileHandler fileHandler;

    /**
     * GeneratedHandler Constructor
     */
    public GeneratedHandler(ServerSocket s, AuxDevice a){
        conHandler = new ConnectionHandler(s,a);
        fileHandler = new FileHandler();
    }

    /**
     * saveGenerated
     * saves usage information in smart meter
     */               
    public void saveGenerated()
    {
        fileHandler.writeGenerated(666.56);
        return;
    }
    
    /**
     * Method updateGenerated
     *
     */
    public void updateGenerated()
    {
        try{
            gen = gen + conHandler.openInterfaceAuxDevice();
            //Generated.addKWH(gen);
        }catch (InvalidSignException i){
            System.out.println("An Error has occoured. Error 665. Please call Paddy.");
        }
    }

    /**
     * getGenerated
     * 
     */               
    public double getGenerated()
    {
        return gen;
    }
    
}
