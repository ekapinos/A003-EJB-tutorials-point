package local.kapinos.console;

import java.io.BufferedReader;

import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import local.kapinos.common.interfaces.ExceptionsSingletonSessionBeanRemote;
import local.kapinos.common.interfaces.MyException;

public class EJBTesterSingletonExceptions extends AbstractEJBTester {

	public static void main(String[] args) {
		new EJBTesterSingletonExceptions().testEjb();
	}
	
	@Override
	protected void doTestEjb(InitialContext ctx, BufferedReader brConsoleReader) throws NamingException {
		ExceptionsSingletonSessionBeanRemote bean = (ExceptionsSingletonSessionBeanRemote)ctx.lookup(JNDI_PREFIX_FOR_EJB_MODULE + "ExceptionsSingletonSessionBean");

		try {
			bean.generateApplicationException();
		} catch (MyException e) {
			System.out.println("Cought " + e);
		}
		try {
			bean.generateSystemException();
		} catch (EJBException e) {
			System.out.println("Cought " + e);
		}
	}

}
