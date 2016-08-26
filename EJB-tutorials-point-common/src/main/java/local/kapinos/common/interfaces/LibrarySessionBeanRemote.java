package local.kapinos.common.interfaces;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LibrarySessionBeanRemote {

	void addBook(String bookName);

	List<String> getBooks();
}