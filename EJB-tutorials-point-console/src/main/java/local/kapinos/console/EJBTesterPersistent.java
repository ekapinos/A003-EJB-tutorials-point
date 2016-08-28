package local.kapinos.console;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import local.kapinos.common.interfaces.LibraryPersistentBeanRemote;
import local.kapinos.common.persistence.Book;

public class EJBTesterPersistent extends AbstractEJBTesterWithBooks<Book>{

	LibraryPersistentBeanRemote libraryBean;

	public static void main(String[] args) {
		new EJBTesterPersistent().testEjb();
	}
	
	@Override
	protected void firstLookup(InitialContext ctx) throws NamingException {
		libraryBean = (LibraryPersistentBeanRemote) ctx.lookup(JNDI_PREFIX_FOR_EJB_MODULE + "LibraryPersistentBean");
	}

	@Override
	protected void addBook(String bookName) {
		libraryBean.addBook(new Book(bookName));	
	}

	@Override
	protected List<Book> getBooksList() {
		return libraryBean.getBooks();
	}
}
