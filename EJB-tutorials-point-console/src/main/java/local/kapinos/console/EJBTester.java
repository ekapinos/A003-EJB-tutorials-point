package local.kapinos.console;

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import local.kapinos.common.interfaces.LibrarySessionBeanRemote;

public class EJBTester {

	public static final String JNDI_PREFIX_FOR_EJB_MODULE = "java:global/EJB-tutorials-point-ear/EJB-tutorials-point-ejb-0.0.1-SNAPSHOT/";
	
	BufferedReader brConsoleReader = null;
	Properties props;
	InitialContext ctx;
	{
		props = new Properties();
		try {
			props.load(EJBTester.class.getClassLoader().getResourceAsStream("jndi.properties"));
			//props.load(new FileInputStream("/jndi.properties"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		try {
			ctx = new InitialContext(props);
		} catch (NamingException ex) {
			ex.printStackTrace();
		}
		brConsoleReader = new BufferedReader(new InputStreamReader(System.in));
	}

	private void showGUI() {
		System.out.println("**********************");
		System.out.println("Welcome to Book Store");
		System.out.println("**********************");
		System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: ");
	}
	
	public <T> void testEjb(String jndiBeanName, Function<String, T> createStringToBookFunction) {
		
		jndiBeanName = JNDI_PREFIX_FOR_EJB_MODULE + jndiBeanName;
		
		try {
			int choice = 1;
			@SuppressWarnings({ "unchecked" })
			LibrarySessionBeanRemote<T> libraryBean = (LibrarySessionBeanRemote<T>) ctx.lookup(jndiBeanName);
			while (choice != 2) {
				String bookName;
				showGUI();
				String strChoice = brConsoleReader.readLine();
				choice = Integer.parseInt(strChoice);
				if (choice == 1) {
					System.out.print("Enter book name: ");
					bookName = brConsoleReader.readLine();
					libraryBean.addBook(createStringToBookFunction.apply(bookName));
				} else if (choice == 2) {
					break;
				}
			}
			List<T> booksList = libraryBean.getBooks();
			System.out.println("Book(s) entered so far: " + booksList.size());
			for (int i = 0; i < booksList.size(); ++i) {
				System.out.println((i + 1) + ". " + booksList.get(i));
			}
			@SuppressWarnings({ "unchecked" })
			LibrarySessionBeanRemote<T> libraryBean1 = (LibrarySessionBeanRemote<T>) ctx.lookup(jndiBeanName);
			List<T> booksList1 = libraryBean1.getBooks();
			System.out.println("***Using second lookup to get library object***");
			System.out.println("Book(s) entered so far: " + booksList1.size());
			for (int i = 0; i < booksList1.size(); ++i) {
				System.out.println((i + 1) + ". " + booksList1.get(i));
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
