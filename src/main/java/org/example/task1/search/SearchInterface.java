package org.example.task1.search;

import org.example.task1.elements.LibraryElementAbstract;

import java.util.List;

public interface SearchInterface {
    public List<LibraryElementAbstract> searchById(String id);
    public List<LibraryElementAbstract> searchByAuth(String auth);
    public List<LibraryElementAbstract> searchByAuthANdId(String id, String auth);
}
