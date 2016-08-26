package local.kapinos.common.interfaces;

import java.util.List;

import javax.ejb.Remote;

import local.kapinos.common.persistence.Book;

@Remote
public interface LibraryPersistentBeanRemote {

	void addBook(Book bookName);

	List<Book> getBooks();
}
