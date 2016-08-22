package local.kapinos.ejb;

import javax.ejb.Singleton;

/**
 * Session Bean implementation class Temp
 */
@Singleton
public class Temp {

    /**
     * Default constructor. 
     */
    public Temp() {
        // TODO Auto-generated constructor stub
    }
    
    public String getSecret(){
    	return "Temp - getSecret";
    }

}
