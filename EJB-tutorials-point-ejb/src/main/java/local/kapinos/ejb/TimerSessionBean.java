package local.kapinos.ejb;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;

import local.kapinos.common.interfaces.TimerSessionBeanRemote;

/**
 * Session Bean implementation class TimerSessionBean
 */
@Stateless
public class TimerSessionBean implements TimerSessionBeanRemote {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Resource
	private SessionContext context;

	@Override
	public void createTimer(long duration) {
		context.getTimerService().createTimer(duration, "Hello World!");
	}

	@Timeout
	public void timeOutHandler(Timer timer) {
		logger.info("timeoutHandler : " + timer.getInfo());
		timer.cancel();
	}

}
