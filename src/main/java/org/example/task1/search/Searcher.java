package org.example.task1.search;


import org.example.task1.elements.LibraryElementAbstract;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Searcher implements SearchInterface {
    private List<LibraryElementAbstract> librabryElements;

    public Searcher(List<LibraryElementAbstract> librabryElements) {
        this.librabryElements = librabryElements;
    }

    @Override
    public List<LibraryElementAbstract> searchById(String id) {
        List<LibraryElementAbstract> findElements = new ArrayList<>();

        for (LibraryElementAbstract el : librabryElements) {
            String elValue = el.getId().trim().toLowerCase();
            if (elValue.equals(id)) {
                findElements.add(el);
            }
        }
        if(findElements.size() == 0){
            System.out.println("Элементов с заданными параметрами не найдено");
        }

        return findElements;
    }

    @Override
    public List<LibraryElementAbstract> searchByAuth(String auth) {
        List<LibraryElementAbstract> findElements = new ArrayList<>();
        for (LibraryElementAbstract el : librabryElements) {
            String elValue = el.getAuth().trim().toLowerCase();
            if (elValue.equals(auth)) {
                findElements.add(el);
            }
        }
        if(findElements.size() == 0){
            System.out.println("Элементов с заданными параметрами не найдено");
        }
        return findElements;
    }

    @Override
    public List<LibraryElementAbstract> searchByAuthANdId(String id, String auth) {
        List<LibraryElementAbstract> findElements = new ArrayList<>();

        for (LibraryElementAbstract el : librabryElements) {
            String elValueId = el.getId().trim().toLowerCase();
            String elValueAuth = el.getAuth().trim().toLowerCase();

            if (elValueId.equals(id)
                    &&
                    elValueAuth.equals(auth)
            ) {
                findElements.add(el);
            }

        }
        if(findElements.size() == 0){
            System.out.println("Элементов с заданными параметрами не найдено");
        }
        return findElements;
    }
}
