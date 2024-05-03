package org.example.task1;

import org.example.task1.elements.LibraryElementAbstract;

import java.util.List;

public class Displayer {
    public void showList(List<LibraryElementAbstract> libraryElementsList){
        if(libraryElementsList.size() < 1){
            System.out.println("Список пуст");
        } else{
            libraryElementsList.forEach(el -> System.out.println(el.getInformationInElement()));
        }
    }
}
