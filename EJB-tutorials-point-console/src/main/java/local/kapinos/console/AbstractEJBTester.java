package local.kapinos.console;

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public abstract class AbstractEJBTester<T> {

	public static final String JNDI_PREFIX_FOR_EJB_MODULE = "java:global/EJB-tutorials-point-ear/EJB-tutorials-point-ejb-0.0.1-SNAPSHOT/";

	private final BufferedReader brConsoleReader;
	private final Properties props;
	private final InitialContext ctx;
	{
		props = new Properties();
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

	private void showGUI() {
		System.out.println("**********************");
		System.out.println("Welcome to Book Store");
		System.out.println("**********************");
		System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: ");
	}

	public abstract void firstLookup(InitialContext ctx) throws Exception;
	public abstract void addBook(String bookName) throws Exception;
	public abstract List<T> getBooksList() throws Exception;
	public List<T> secondLookupAndGetBooksList(InitialContext ctx) throws Exception {
		firstLookup(ctx);
		return getBooksList();
	}

	public void testEjb() {

		try {
			int choice = 1;

			firstLookup(ctx);

			while (choice != 2) {
				String bookName;
				showGUI();
				String strChoice = brConsoleReader.readLine();
				choice = Integer.parseInt(strChoice);
				if (choice == 1) {
					System.out.print("Enter book name: ");
					bookName = brConsoleReader.readLine();

					addBook(bookName);

				} else if (choice == 2) {
					break;
				}
			}
			List<T> booksList = getBooksList();
			System.out.println("Book(s) entered so far: " + booksList.size());
			for (int i = 0; i < booksList.size(); ++i) {
				System.out.println((i + 1) + ". " + booksList.get(i));
			}

			List<T> booksList1 = secondLookupAndGetBooksList(ctx);
			if (booksList1 != null) {
				System.out.println("***Using second lookup to get library object***");
				System.out.println("Book(s) entered so far: " + booksList1.size());
				for (int i = 0; i < booksList1.size(); ++i) {
					System.out.println((i + 1) + ". " + booksList1.get(i));
				}
			}
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
}
