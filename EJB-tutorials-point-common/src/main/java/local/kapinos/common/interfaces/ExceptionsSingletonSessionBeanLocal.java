package local.kapinos.common.interfaces;

import javax.ejb.Remote;

@Remote
public interface ExceptionsSingletonSessionBeanLocal {
	
	String getSecret();
}
