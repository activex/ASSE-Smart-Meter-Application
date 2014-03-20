/**
 *Usage Class
 *
 *Object for storing Usage Information
 *
 *price = price per kwh
 *kwh = amount used
 *sTime = start time of the block
 *eTime = end time of the block
 * 
 * @author Marc Reinhardt 
 * @version 0.2
 */
package SmartMeter;
import java.util.*;

public class Usage
{
    private double price;
    private double kwh;
    private Date sTime;
    private Date eTime;

    public Usage(double p){
        price = p;
        sTime = new Date();
        kwh = 0;
    }

    public double getPrice(){
        return price;
    }

    private void setPrice(double p){
        price = p;
    }

    public double getKwh(){
        return kwh;
    }

    private void setKwh(double k){
        kwh = k;
    }

    public Date getET(){ 
        return (java.util.Date)eTime.clone();
    }

    public void setET(){
        eTime = new Date();
    }

    public double getCost(){
        return price*kwh;
    }

    public void addUsage(double u){
        kwh = kwh + u;
    }

}
