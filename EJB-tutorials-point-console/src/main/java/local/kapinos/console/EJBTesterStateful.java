package local.kapinos.console;

public class EJBTesterStateful {

	public static void main(String[] args) {
		new EJBTester().testEjb("LibraryStatefulSessionBean", s -> s);
	}
}
