package local.kapinos;

import java.util.List;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class LibrarySessionBean
 */
@Stateless
public class LibrarySessionBean implements LibrarySessionBeanRemote {

	List<String> bookShelf;

	public void addBook(String bookName) {
		bookShelf.add(bookName);
	}

	public List<String> getBooks() {
		return bookShelf;
	}
}
