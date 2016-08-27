package local.kapinos.common.interfaces;

import java.util.List;

public interface LibrarySessionBeanRemote<T> {

	void addBook(T bookName);

	List<T> getBooks();

}
