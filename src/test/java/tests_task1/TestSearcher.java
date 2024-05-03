package tests_task1;

import org.example.task1.elements.*;
import org.example.task1.search.Searcher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSearcher {
    private static List<LibraryElementAbstract> libraryList = new ArrayList<>();
    @BeforeAll
    public static void createList(){
        libraryList.add(new Book("1", "Book", "test author 1", "test duration 1"));
        libraryList.add(new Book("2", "Book", "test author 2", "test duration 2"));
        libraryList.add(new Book("1", "Book", "test author 1", "test duration 3"));
        libraryList.add(new Letter("4", "Letter", "test author 1", "recipient 1", "sender 1"));
        libraryList.add(new Letter("5", "Letter", "test author 5", "recipient 2", "sender 2"));
        libraryList.add(new Letter("6", "Letter", "test author 6", "recipient 3", "sender 3"));
        libraryList.add(new Journal("7", "Journal", "test author 7", "publishing house 1", "publication 1"));
        libraryList.add(new Journal("9", "Journal", "test author 9", "publishing house 2", "publication 1"));
        libraryList.add(new Journal("9", "Journal", "test author 9", "publishing house 3", "publication 1"));
        libraryList.add(new Microfilm("10", "Microfilm", "test author 10", "duration 1", "format 1"));
        libraryList.add(new Microfilm("11", "Microfilm", "test author 11", "duration 2", "format 2"));
        libraryList.add(new Microfilm("12", "Microfilm", "test author 12", "duration 3", "format 3"));
    }
    @ParameterizedTest
    @CsvSource({
            "test author 1, 3",
            "test author 5, 1"
    })
    // первое значение auth, второе значение количество найденных элементов
    public void checkSearcherById(String id, String quantity){
        Searcher searcher = new Searcher(libraryList);

        assertEquals(quantity, String.valueOf(searcher.searchByAuth(id).size()));

    }

    @ParameterizedTest
    @CsvSource({
            "test author 1, 3",
            "test author 11, 1"
    })
    // первое значение id, второе значение количество найденных элементов
    public void checkSearcherByAuth(String id, String quantity){
        Searcher searcher = new Searcher(libraryList);

        assertEquals(quantity, String.valueOf(searcher.searchByAuth(id).size()));

    }
    @ParameterizedTest
    @CsvSource({
            "9, test author 9, 2",
            "10, test author 10, 1"
    })
    // первое значение id, второе значение auth, третье значение количество найденных элементов
    public void checkSearcherByIdAndAuth(String id, String auth, String quantity){
        Searcher searcher = new Searcher(libraryList);

        assertEquals(quantity, String.valueOf(searcher.searchByAuthANdId(id, auth).size()));

    }
    @ParameterizedTest
    @CsvSource({
            "13, 0",
    })
    // первое значение id, второе значение количество найденных элементов
    public void checkSearcherEmptyResultId(String id, String quantity){
        Searcher searcher = new Searcher(libraryList);

        assertEquals(quantity, String.valueOf(searcher.searchById(id).size()));

    }

    @ParameterizedTest
    @CsvSource({
            "test author 111, 0",
    })
    // первое значение id, второе значение количество найденных элементов
    public void checkSearcherEmptyResultByAuth(String id, String quantity){
        Searcher searcher = new Searcher(libraryList);

        assertEquals(quantity, String.valueOf(searcher.searchById(id).size()));

    }

    @ParameterizedTest
    @CsvSource({
            "13, test author 12, 0", // id не существует,  auth  существует
            "12, test author 13, 0", // id  существует,  auth не существует
            "13, test author 13, 0" // id не существует,  auth не существует
    })
    // первое значение id, второе значение auth, третье значение количество найденных элементов
    public void checkSearcherEmptyResultByIdAndAuth(String id, String auth, String quantity){
        Searcher searcher = new Searcher(libraryList);

        assertEquals(quantity, String.valueOf(searcher.searchByAuthANdId(id, auth).size()));

    }
}
