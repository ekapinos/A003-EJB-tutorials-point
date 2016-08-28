package local.kapinos.console;

import java.io.BufferedReader;
import java.util.Date;

import javax.naming.InitialContext;

import local.kapinos.common.interfaces.TimerSessionBeanRemote;

public class EJBTesterTimer extends AbstractEJBTester {

	public static void main(String[] args) {
		new EJBTesterTimer().testEjb();
	}
	
	@Override
	protected void doTestEjb(InitialContext ctx, BufferedReader brConsoleReader) throws Exception {
		TimerSessionBeanRemote timerServiceBean = (TimerSessionBeanRemote)ctx.lookup(JNDI_PREFIX_FOR_EJB_MODULE + "TimerSessionBean");

        System.out.println("["+(new Date()).toString()+ "]" + "timer created.");
        timerServiceBean.createTimer(2000);    
	}

}
