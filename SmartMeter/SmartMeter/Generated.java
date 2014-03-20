/**
 *Generated Class
 * 
 *Object for storing Generated Information
 *
 *gprice = price per generated kwh
 *gkwh = amount generated
 *sTime = start time of the block
 *eTime = end time of the block
 * 
 * @author Marc Reinhardt 
 * @version 0.2
 */
package SmartMeter;
import java.util.*;

public class Generated
{
    private double gprice;
    private double gkwh;
    private Date sTime;
    private Date eTime;

    public Generated(double p){
        gprice = p;
        sTime = new Date();
        gkwh = 0;
    }

    public double getPrice(){
        return gprice;
    }

    private void setPrice(double p){
        gprice = p;
    }

    public double getKwh(){
        return gkwh;
    }

    private void setKwh(double k){
        gkwh = k;
    }

    public Date getET(){
        return (java.util.Date)eTime.clone();
    }

    public void setET(){
        eTime = new Date();
    }

    public double getCost(){
        return gprice*gkwh;
    }

    public void addKWH(double u){
        gkwh = gkwh + u;
    }

}
