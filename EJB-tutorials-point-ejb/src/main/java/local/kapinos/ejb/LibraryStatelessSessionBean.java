package local.kapinos.ejb;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import local.kapinos.common.interfaces.LibraryStatelessSessionBeanRemote;

/**
 * Session Bean implementation class LibrarySessionBean
 */
@Stateless
@Interceptors ({BusinessInterceptor.class})
public class LibraryStatelessSessionBean implements LibraryStatelessSessionBeanRemote {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private List<String> bookShelf;

	public LibraryStatelessSessionBean() {
		bookShelf = new ArrayList<String>();
	}
	
	public void addBook(String bookName) {
		bookShelf.add(bookName);
	}

	public List<String> getBooks() {
		return bookShelf;
	}
	
	@PostConstruct
	public void beanCreated(){
		logger.info(getClass() + " - @PostConstruct");
	}
	@PreDestroy
	public void beanDestroyed(){
		logger.info(getClass() + " - @PreDestroy");
	}
}
