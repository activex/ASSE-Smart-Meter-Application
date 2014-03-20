/**
 * SignedGenerated Class
 * 
 * @author Marc Reinhardt    
 * @version 0.2
 */

package AuxDevice;

public class SignedGenerated
{

    private int sig;
    private double generated;
    
    public SignedGenerated(int s, double p){
        sig = s;
        generated = p;
    }

    public double getGenerated(){
    return generated;
    }
    
    public int getSig(){
    return sig;
    }
    
}

