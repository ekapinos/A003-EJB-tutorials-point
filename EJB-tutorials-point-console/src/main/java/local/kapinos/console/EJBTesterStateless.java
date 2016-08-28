package local.kapinos.console;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import local.kapinos.common.interfaces.LibraryStatelessSessionBeanRemote;

public class EJBTesterStateless extends AbstractEJBTesterWithBooks<String>{

	LibraryStatelessSessionBeanRemote libraryBean;

	public static void main(String[] args) {
		new EJBTesterStateless().testEjb();
	}
	
	@Override
	protected void firstLookup(InitialContext ctx) throws NamingException {
		libraryBean = (LibraryStatelessSessionBeanRemote) ctx.lookup(JNDI_PREFIX_FOR_EJB_MODULE + "LibraryStatelessSessionBean");
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
