/**
 * SmartApp Class
 * 
 * Creates a simulation of an Smart Appliance which is able to communicate
 * with the smart meter.
 * 
 * @author Marc Reinhardt
 * @version 0.3
 */

package SmartAppliance;

public class SmartApp
{

    private SignedCom com;              //Creates new Signed com Object
    private String msg;
    
    public SmartApp(){
        msg = "Hallo Hallo Hallo";
        com = new SignedCom(6,msg);
    }
   
    public void signatureTest(){
        msg = "End the world.exe";
        com = new SignedCom(99, msg);
    }
    
    public  SignedCom updateCom(){
        return com;
    }
  
}