package org.example.task1;

import org.example.task1.elements.LibraryElementAbstract;
import org.example.task1.search.Searcher;

import java.util.List;

public class Library {
    private List<LibraryElementAbstract> DATABASE_LIBRARY;
    private Searcher searcher;
    public void initLibrary(){
        DATABASE_LIBRARY = new Generator().generateLibraryElements(10);
    }
    public List<LibraryElementAbstract> getDATABASE_LIBRARY() {
        return DATABASE_LIBRARY;
    }

}
