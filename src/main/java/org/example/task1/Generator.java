package org.example.task1;

import org.example.task1.elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    private String[] libraryCategory = {"Book", "Journal", "Letter", "Microfilm"};
    private int id;
    private String[] titles = {"test title 1", "test title 2", "test title 3", "test title 4", "test title 5"};
    private String[] authors = {"test author 1", "test author 2", "test author 3", "test author 4", "test author 5"};
    private String[] publishingHouses = {"test publishing house 1", "test publishing house  2", "test publishing house  3", "test publishing house  4", "test publishing house  5"};
    private String[] publications = {"test publication 1", "test publication 2", "test publication 3", "test publication 4", "test publication 5"};
    private String[] recipients = {"test recipient 1", "test recipient 2", "test recipient 3", "test recipient 4", "test recipient 5"};
    private String[] senders = {"test sender 1", "test sender 2", "test sender 3", "test sender 4", "test sender 5"};
    private String[] durations = {"test duration 1", "test duration 2", "test duration 3", "test duration 4", "test duration 5"};
    private String[] formats = {"test format 1", "test format 2", "test format 3", "test format 4", "test format 5"};
    public List<LibraryElementAbstract> generateLibraryElements(int quantityELements){
        List<LibraryElementAbstract> DATABASE_LIBRARY = new ArrayList<>();
        for(int i = 1 ; i <= quantityELements; i++){
            String id = String.valueOf(i);
            switch (getRandomCategory()){
                case "Book":
                    DATABASE_LIBRARY.add(
                            new Book(
                                    id,
                            "Book",
                                    authors[getRandomValue(0, authors.length)],
                                titles[getRandomValue(0, titles.length)]

                            ));
                    break;
                case "Journal":
                    DATABASE_LIBRARY.add(
                            new Journal(
                                    id,
                                    "Journal",
                                    authors[getRandomValue(0, authors.length)],
                                    publishingHouses[getRandomValue(0, publishingHouses.length)],
                                    publications[getRandomValue(0, publications.length)]
                            ));
                    break;
                case "Letter":
                    DATABASE_LIBRARY.add(
                            new Letter(
                                    id,
                                    "Letter",
                                    authors[getRandomValue(0, authors.length)],
                                    recipients[getRandomValue(0, recipients.length)],
                                    senders[getRandomValue(0, senders.length)]
                            ));
                    break;
                case "Microfilm":
                    DATABASE_LIBRARY.add(
                            new Microfilm(
                                    id,
                                    "Microfilm",
                                    authors[getRandomValue(0, authors.length)],
                                    durations[getRandomValue(0, durations.length)],
                                    formats[getRandomValue(0, formats.length)]
                            ));
                    break;
            }
        }
        return DATABASE_LIBRARY;
    }
    private String getRandomCategory(){
        return libraryCategory[new Random().nextInt(0, libraryCategory.length)];
    }
    private int getRandomValue(int min, int max){
        return new Random().nextInt(min, max);
    }
}
