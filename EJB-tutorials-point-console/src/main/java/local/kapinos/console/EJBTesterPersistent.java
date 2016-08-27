package local.kapinos.console;

import local.kapinos.common.persistence.Book;

public class EJBTesterPersistent {
	
	public static void main(String[] args) {
		new EJBTester().testEjb("LibraryPersistentBean", s -> new Book(s));
	}
}
