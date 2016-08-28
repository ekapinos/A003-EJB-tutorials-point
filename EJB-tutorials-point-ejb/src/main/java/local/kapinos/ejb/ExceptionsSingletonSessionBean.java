package local.kapinos.ejb;

import javax.ejb.EJBException;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import local.kapinos.common.interfaces.ExceptionsSingletonSessionBeanLocal;
import local.kapinos.common.interfaces.ExceptionsSingletonSessionBeanRemote;
import local.kapinos.common.interfaces.MyException;

/**
 * Session Bean implementation class Temp
 */
@Startup
@Singleton
public class ExceptionsSingletonSessionBean implements ExceptionsSingletonSessionBeanRemote, ExceptionsSingletonSessionBeanLocal {

    /**
     * Default constructor. 
     */
    public ExceptionsSingletonSessionBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public String getSecret(){
    	return "Temp - getSecret";
    }

	@Override
	public void generateApplicationException() throws MyException {
		throw new MyException();
	}

	@Override
	public void generateSystemException() throws EJBException {
		MyException myException = new MyException();
		
		EJBException ejbException = new EJBException(myException);
		ejbException.initCause(myException);
		throw ejbException;
	}
}
