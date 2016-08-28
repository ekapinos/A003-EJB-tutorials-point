package local.kapinos.console;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import local.kapinos.ws.Book;
import local.kapinos.ws.LibraryPersistentBean;
import local.kapinos.ws.LibraryService;
import local.kapinos.ws.LibraryServiceLocator;

public class EJBWebServiceClient {
	public static void main(String[] args) throws ServiceException, RemoteException {

		LibraryService service = new LibraryServiceLocator();
		LibraryPersistentBean port = service.getLibraryPersistentBeanPort();
		for (Book book : port.getBooks()) {
			System.out.println(book.getName());
		}
	}

}
