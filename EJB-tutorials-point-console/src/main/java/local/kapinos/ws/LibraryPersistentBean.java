/**
 * LibraryPersistentBean.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package local.kapinos.ws;

public interface LibraryPersistentBean extends java.rmi.Remote {
    public void addBook(java.lang.Object arg0) throws java.rmi.RemoteException;
    public local.kapinos.ws.Book[] getBooks() throws java.rmi.RemoteException;
}
