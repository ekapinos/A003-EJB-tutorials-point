package local.kapinos.common.interfaces;

import javax.ejb.Remote;

@Remote
public interface TimerSessionBeanRemote {
	void createTimer(long duration);
}
