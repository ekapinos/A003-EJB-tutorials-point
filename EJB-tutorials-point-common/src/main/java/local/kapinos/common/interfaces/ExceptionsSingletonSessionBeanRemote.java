package local.kapinos.common.interfaces;

import javax.ejb.EJBException;
import javax.ejb.Remote;

@Remote
public interface ExceptionsSingletonSessionBeanRemote {
	
	void generateApplicationException() throws MyException;
	
	void generateSystemException() throws EJBException;
}
