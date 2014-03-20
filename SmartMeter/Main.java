
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import SmartMeter.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Server.*;
import AuxDevice.*;
import SmartAppliance.*;

public class Main
{    
    public static void testSigServer(ServerSocket server){
        SmartEngine se = new SmartEngine(server);

        //output old price
        System.out.println("Old Price");
        System.out.println(se.getPrice());
        System.out.println(se.getgPrice());
        
        se.comUpdatePrice();
        se.comUpdateGeneratedPrice();
        
        //output new price
        System.out.println("New Price");
        System.out.println(se.getPrice());
        System.out.println(se.getgPrice());
        

    }
    
    public static void testSigAux(ServerSocket server, AuxDevice aux){
        SmartEngine se = new SmartEngine(server,aux);

        //output generated
        System.out.println("Old Generated");
        se.getGenerated();
        
        //update generated
        System.out.println("Add Generated");
        se.addGenerated();
        
        System.out.println("New Generated");
        //output new generated
        se.getGenerated();

    }
    
    public static void testSigSA(SmartApp sa){
        SmartEngine se = new SmartEngine(sa);
        
        System.out.println("Communication from SA -> SM");
        se.comGetSmartCom();
    
    }

    public static void main(String [ ] args)
    {
        ServerSocket sovalid = new ServerSocket();
        ServerSocket soinvalid = new ServerSocket();
        soinvalid.signatureTest(); //creates invalid server
        
        AuxDevice auxvalid = new AuxDevice();
        AuxDevice auxinvalid = new AuxDevice();
        auxinvalid.signatureTest(); //creates invalid aux device
        
        SmartApp savalid = new SmartApp();
        SmartApp sainvalid = new SmartApp();
        sainvalid.signatureTest(); //creates invalid aux device

        //testSig(soinvalid);
        //testSig(sovalid);
        
        System.out.println("  _________                      __       _____          __                 ");
        System.out.println(" /   _____/ _____ _____ ________/  |_    /     \\   _____/  |_  ___________  ");
        System.out.println(" \\_____  \\ /     \\\\__  \\\\_  __ \\   __\\  /  \\ /  \\_/ __ \\   __\\/ __ \\_  __ \\ ");
        System.out.println(" /        \\  Y Y  \\/ __ \\|  | \\/|  |   /    Y    \\  ___/|  | \\  ___/|  | \\/ ");
        System.out.println("/_______  /__|_|  (____  /__|   |__|   \\____|__  /\\___  >__|  \\___  >__|    ");
        System.out.println("        \\/      \\/     \\/                      \\/     \\/          \\/        ");
        System.out.println(" ----------- // TEST MODULE \\\\ ----------- ");

        int i = 0;
        while(i == 0){

            System.out.println("");
            System.out.println("");
            System.out.println("Main Menu");
            System.out.println("--------------------------");
            System.out.println("(1) - AA1-2 Test Server Signature on Updateing Price Information");
            System.out.println("(2) - AA3-4 Test Auxdevice Signature on Updateing Generated Power Information");
            System.out.println("(3) - AA5-6 Test SmartDevice Sigature for Communication");
            System.out.println("(0) Exit");
            System.out.println("");
            System.out.println("");
            System.out.println("Choose option 0-9: ");

            try{
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                String cinput = bufferRead.readLine();

                //System.out.println(cinput);
                System.out.println("");
                System.out.println("");

                if(cinput.equals("1")){
                    System.out.println("--------- > START Server Signature for Updateing Price Information");
                    System.out.println("--------- > Testing Valid Server");
                    testSigServer(sovalid);
                    System.out.println("--------- > Testing Invalid Server");
                    testSigServer(soinvalid);
                    System.out.println("--------- > END Server Signature for Updateing Price Information");
                }
                if(cinput.equals("2")){
                    System.out.println("--------- > START Test Auxdevice Signature on Updateing Generated Power Information");
                    System.out.println("--------- > Testing Valid AuxDevice");
                    testSigAux(sovalid,auxvalid);
                    System.out.println("--------- > Testing Invalid AuxDevice");
                    testSigAux(sovalid,auxinvalid);
                    System.out.println("--------- > END Test Auxdevice Signature on Updateing Generated Power Information");
                }
                if(cinput.equals("3")){
                    System.out.println("--------- > START Test SmartAppliance Sigature for Communication");
                    System.out.println("--------- > Testing Valid SmartAppliance");
                    testSigSA(savalid);
                    System.out.println("--------- > Testing Inalid SmartAppliance");
                    testSigSA(sainvalid);
                    System.out.println("--------- > END Test SmartAppliance Sigature for Communication");
                }
                if(cinput.equals("4")){

                }
                if(cinput.equals("5")){

                }
                if(cinput.equals("6")){
//                     double a; //= se.getPrice();
//                     double b; //= se.getgPrice();
//                     double c; //= se.getCost();
// 
//                     System.out.println("Power Price: " + a);
// 
//                     System.out.println("Generated Power Price: " + b);
// 
//                     System.out.println("Usage Cost: " + c);

                }
                if(cinput.equals("0")){
                    i = 1;
                    System.exit(0);
                }

            }     
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
