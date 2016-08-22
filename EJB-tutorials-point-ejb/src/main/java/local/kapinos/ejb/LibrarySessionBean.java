package local.kapinos.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import local.kapinos.common.LibrarySessionBeanRemote;

/**
 * Session Bean implementation class LibrarySessionBean
 */
@Stateless
public class LibrarySessionBean implements LibrarySessionBeanRemote {

	List<String> bookShelf;

	public LibrarySessionBean() {
		bookShelf = new ArrayList<String>();
	}

	public void addBook(String bookName) {
		bookShelf.add(bookName);
	}

	public List<String> getBooks() {
		return bookShelf;
	}
}
