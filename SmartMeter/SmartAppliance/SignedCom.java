package SmartAppliance;


/**
 * SignedCom Class]
 * 
 * Creates the SignedCom Object which stores a signature and the communication string.
 * 
 * @author Marc Reinhardt
 * @version 0.2
 */
public class SignedCom
{

    private int sig;
    private String com;
    
    public SignedCom(int s, String c){
        sig = s;
        com = c;
    }

    public String getCom(){
    return com;
    }
    
    public int getSig(){
    return sig;
    }
    
}

