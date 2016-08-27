package local.kapinos.common.interfaces;

import javax.ejb.Remote;

import local.kapinos.common.persistence.Book;

@Remote
public interface LibraryPersistentBeanRemote extends LibrarySessionBeanRemote<Book>{

}
