package local.kapinos.console;

public class EJBTesterStateless {

	public static void main(String[] args) {
		new EJBTester().testEjb("LibraryStatelessSessionBean", s -> s);
	}
}
