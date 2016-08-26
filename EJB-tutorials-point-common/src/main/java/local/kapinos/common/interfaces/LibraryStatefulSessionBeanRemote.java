package local.kapinos.common.interfaces;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface LibraryStatefulSessionBeanRemote {

	void addBook(String bookName);

	List<String> getBooks();

}
