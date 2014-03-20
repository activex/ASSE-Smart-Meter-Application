/**
 * SignedgPrice Class
 * Object to store price and signature
 * 
 * @author Marc Reinhardt
 * @version 0.2
 */

package Server;

public class SignedgPrice
{

    private int sig;
    private double price;
    
    public SignedgPrice(int s, double p){
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
