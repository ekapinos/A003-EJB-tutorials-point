package local.kapinos.ejb;

import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class BusinessInterceptor {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@AroundInvoke
	public Object methodInterceptor(InvocationContext ctx) throws Exception {
		logger.info("*** Intercepting call to LibraryBean method: " + ctx.getMethod().getName());
		return ctx.proceed();
	}
}
