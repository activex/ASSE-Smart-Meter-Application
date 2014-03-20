/**
 * File
 * This implements the connection to the remote server of the utility provider to receive
 * usage data and update the current price
 * 
 * @author Marc Reinhardt
 * @version 0.2
 */

package SmartMeter;

public class File
{   
    private String a;
    private int sig = 4;
    
    public File(){};

    public String getFile(){
        return a;
    }
    
    public int getSig(){
        return sig;
    }
    
    public void setFile(String b){
        a = b;
    }
    
}
