package local.kapinos.console;

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public abstract class AbstractEJBTester {

	public static final String JNDI_PREFIX_FOR_EJB_MODULE = "java:global/EJB-tutorials-point-ear/EJB-tutorials-point-ejb-0.0.1-SNAPSHOT/";

	private final BufferedReader brConsoleReader;
	private final InitialContext ctx;
	{
		Properties props = new Properties();
		try {
			props.load(AbstractEJBTester.class.getClassLoader().getResourceAsStream("jndi.properties"));
			// props.load(new FileInputStream("/jndi.properties"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		InitialContext ctx = null;
		try {
			ctx = new InitialContext(props);
		} catch (NamingException ex) {
			ex.printStackTrace();
		}
		this.ctx = ctx;
		brConsoleReader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void testEjb() {
		try {
			doTestEjb(ctx, brConsoleReader);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (brConsoleReader != null) {
					brConsoleReader.close();
				}
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
	protected abstract void doTestEjb(InitialContext ctx, BufferedReader brConsoleReader) throws Exception;
	
}
