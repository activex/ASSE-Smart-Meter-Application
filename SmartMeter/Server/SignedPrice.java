/**
 * SignedPrice Class
 * Object to store price and signature
 * 
 * @author Marc Reinhardt
 * @version 0.2
 */

package Server;

public class SignedPrice
{

    private int sig;
    private double price;
        
    public SignedPrice(int s, double p){
        sig = s;
        price = p;
    }

    public double getPrice(){
    return price;
    }
    
    public int getSig(){
    return sig;
    }
    
}
