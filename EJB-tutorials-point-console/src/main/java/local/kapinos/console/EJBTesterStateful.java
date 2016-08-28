package local.kapinos.console;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import local.kapinos.common.interfaces.LibraryStatefulSessionBeanRemote;

public class EJBTesterStateful extends AbstractEJBTesterWithBooks<String>{

	LibraryStatefulSessionBeanRemote libraryBean;

	public static void main(String[] args) {
		new EJBTesterStateful().testEjb();
	}
	
	@Override
	protected void firstLookup(InitialContext ctx) throws NamingException {
		libraryBean = (LibraryStatefulSessionBeanRemote) ctx.lookup(JNDI_PREFIX_FOR_EJB_MODULE + "LibraryStatefulSessionBean");
	}

	@Override
	protected void addBook(String bookName) {
		libraryBean.addBook(bookName);	
	}

	@Override
	protected List<String> getBooksList() {
		return libraryBean.getBooks();
	}
}
