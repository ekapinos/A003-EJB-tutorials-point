package local.kapinos.console;

import java.io.BufferedReader;
import java.util.List;

import javax.naming.InitialContext;

public abstract class AbstractEJBTesterWithBooks<T> extends AbstractEJBTester {


	private void showGUI() {
		System.out.println("**********************");
		System.out.println("Welcome to Book Store");
		System.out.println("**********************");
		System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: ");
	}

	protected abstract void firstLookup(InitialContext ctx) throws Exception;
	protected abstract void addBook(String bookName) throws Exception;
	protected abstract List<T> getBooksList() throws Exception;
	protected List<T> secondLookupAndGetBooksList(InitialContext ctx) throws Exception {
		firstLookup(ctx);
		return getBooksList();
	}
	
	@Override
	protected void doTestEjb(InitialContext ctx, BufferedReader brConsoleReader) throws Exception {
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
	}
}
