/**
 * SmartEngine Class
 * 
 * Main SmartMeter Component
 * 
 * @author Marc Reinhardt
 * @version 0.8
 */
package SmartMeter;
import java.util.*;
import Server.*;
import AuxDevice.*;
import SmartAppliance.*;

public class SmartEngine
{
    private  PriceHandler priceHandler;
    private  UsageHandler usageHandler;
    private  GeneratedHandler generatedHandler;
    private  FileHandler fileHandler;
    
   

    private  Vector usage;
    private  Usage currentUsage;

    private  Vector generated;
    private  Generated currentGenerated;

    private SmartApp app;

    private ConnectionHandler conHandler;

    ServerSocket server;
    AuxDevice aux;

    /**
     * Constructors for SmartEngine
     */
    /**
     * SmartEngine Constructor
     * with Server
     */
    public SmartEngine(ServerSocket s)
    {
        server = s;
        priceHandler = new PriceHandler(server);
        priceHandler.initPriceHandler(); //initial

        usage = new Vector();
        currentUsage = new Usage(priceHandler.getPrice());

        generated = new Vector();
        currentGenerated = new Generated(priceHandler.getgPrice());

        usageHandler = new UsageHandler(server);
        
        fileHandler = new FileHandler();
    }

    /**
     * SmartEngine Constructor
     * with SmartAppliance
     */
    public SmartEngine(SmartApp a)
    {
        app = a;

        conHandler = new ConnectionHandler(a);
    }
    
    /**
     * SmartEngine Constructor
     * with Server and Auxlilary Device
     */
    public SmartEngine(ServerSocket s, AuxDevice a)
    {
        server = s;
        aux = a;
        priceHandler = new PriceHandler(server);
        priceHandler.initPriceHandler(); //initial

        usage = new Vector();
        currentUsage = new Usage(priceHandler.getPrice());

        generatedHandler = new GeneratedHandler(server,aux);

        generated = new Vector();
        currentGenerated = new Generated(priceHandler.getgPrice());

        usageHandler = new UsageHandler(server);
        fileHandler = new FileHandler();
    }

    /**
     * Method comUpdatePrice
     * trigger price update, calling update function in PriceHander
     * ending current usage block
     * starting new usage block
     */
    public void comUpdatePrice()
    {
        priceHandler.updatePrice();
        currentUsage.setET();
        usage.add(currentUsage);                           //add old one to usage vector 
        currentUsage = new Usage(priceHandler.getPrice()); // create new usage block
    }

    /**
     * Method comGetSmartCom
     * Communication with SmartAppliace
     */
    public void comGetSmartCom(){

        try{
            System.out.println(conHandler.openInterfaceSmartApp());
        }catch (InvalidSignException i){
            System.out.println("An Error has occoured. Error 666. Please call Paddy.");
        }
        return;
    }

    /**
     * Method comUpdateGeneratedPrice
     * trigger price update, calling update function in PriceHander
     * ending current generated block
     * starting new generated block
     */
    public void comUpdateGeneratedPrice()
    {
        priceHandler.updategPrice();
        currentGenerated.setET();
        generated.add(currentGenerated);                             //add old one to usage vectore
        currentGenerated = new Generated(priceHandler.getgPrice()); // create new usage block
    }

    /**
     * Method comSendUsage
     * Send usage data to provider
     */
    public  void comSendUsage()
    {
        usageHandler.updateUsage("cust000001");
    }

    /**
     * Method comSendGenerated
     * Send generated data to provider
     */
    public  void comSendGenerated()
    {
        generatedHandler.updateGenerated();
    }

    /**
     * Method getPrice
     * return current usage price
     */
    public  double getPrice()
    {
        return priceHandler.getPrice();
    }

    /**
     * Method getgPrice
     * return current generated price
     */
    public  double getgPrice()
    {
        return priceHandler.getgPrice();
    }

    /**
     * Method getGenerated
     * return amount generated
     */
    public  double getGenerated()
    {
        //return generatedHandler.getGenerated();
        currentGenerated.setET();
        generated.add(currentGenerated);
        currentGenerated = new Generated(priceHandler.getgPrice());

        int i = 0;
        double gen = 0;
        Generated tmp;

        while(i<generated.size()){
            tmp = (Generated)generated.get(i);
            gen = gen + tmp.getKwh();
            i++;
        }

        System.out.println(gen+"");
        return gen;
    }

    /**
     * Method addUsage
     *
     */
    public void addUsage(){
        currentUsage.addUsage(UsedKWHs.updateKWH());
        fileHandler.writeUsage(22.22);        //saves usage data to file.
    }

    /**
     * Method addGenerated
     *
     */
    public void addGenerated(){
        generatedHandler.updateGenerated();
        currentGenerated.addKWH(getGenerated());
        currentGenerated.addKWH(generatedHandler.getGenerated());
        fileHandler.writeGenerated(getGenerated());               //saves usage data to file.
    }

    /**
     * Method getCost
     * return current cost
     */
    public double getCost(){
        currentUsage.setET();
        usage.add(currentUsage);                             //add old one to usage vectore
        currentUsage = new Usage(priceHandler.getPrice());   //create new usage block

        int i = 0;
        double cost = 0;
        Usage tmp;

        while(i<usage.size()){
            tmp = (Usage)usage.get(i);
            cost = cost + tmp.getCost();
            i++;
        }

        System.out.println(cost+"");
        return cost;

    }

}

