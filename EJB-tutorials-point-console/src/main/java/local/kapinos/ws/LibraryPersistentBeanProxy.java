package local.kapinos.ws;

public class LibraryPersistentBeanProxy implements local.kapinos.ws.LibraryPersistentBean {
  private String _endpoint = null;
  private local.kapinos.ws.LibraryPersistentBean libraryPersistentBean = null;
  
  public LibraryPersistentBeanProxy() {
    _initLibraryPersistentBeanProxy();
  }
  
  public LibraryPersistentBeanProxy(String endpoint) {
    _endpoint = endpoint;
    _initLibraryPersistentBeanProxy();
  }
  
  private void _initLibraryPersistentBeanProxy() {
    try {
      libraryPersistentBean = (new local.kapinos.ws.LibraryServiceLocator()).getLibraryPersistentBeanPort();
      if (libraryPersistentBean != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)libraryPersistentBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)libraryPersistentBean)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (libraryPersistentBean != null)
      ((javax.xml.rpc.Stub)libraryPersistentBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public local.kapinos.ws.LibraryPersistentBean getLibraryPersistentBean() {
    if (libraryPersistentBean == null)
      _initLibraryPersistentBeanProxy();
    return libraryPersistentBean;
  }
  
  public void addBook(java.lang.Object arg0) throws java.rmi.RemoteException{
    if (libraryPersistentBean == null)
      _initLibraryPersistentBeanProxy();
    libraryPersistentBean.addBook(arg0);
  }
  
  public local.kapinos.ws.Book[] getBooks() throws java.rmi.RemoteException{
    if (libraryPersistentBean == null)
      _initLibraryPersistentBeanProxy();
    return libraryPersistentBean.getBooks();
  }
  
  
}