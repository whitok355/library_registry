package tests_task1;

import org.example.task1.Generator;
import org.example.task1.elements.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestGenerator {

    @ParameterizedTest
    @ValueSource(ints={10, 20, 30, 50})
    public void checkQuantityGenerationElements(int quantityElement){
        Generator generator = new Generator();

        List<LibraryElementAbstract> listLibraryElements = generator.generateLibraryElements(quantityElement);

        assertEquals(quantityElement, listLibraryElements.size());

    }

    @Test
    public void checkStructureGenerationElement(){
        Generator generator = new Generator();

        List<LibraryElementAbstract> listLibraryElements = generator.generateLibraryElements(10);

        LibraryElementAbstract book = null;
        LibraryElementAbstract journal= null;
        LibraryElementAbstract letter= null;
        LibraryElementAbstract microfilm= null;

        // проверяю структура элемента библиотеки
        for(LibraryElementAbstract el : listLibraryElements){
            assertNotNull(el.getId());
            assertNotNull(el.getAuth());

            if(el.getCategory().equals("Book")){
                book = el;
                assertEquals("Book", el.getCategory());
                assertNotNull(((Book)el).getTitle());
            } else if (el.getCategory().equals("Journal")) {
                journal = el;
                assertNotNull(((Journal)el).getPublishingHouse());
                assertNotNull(((Journal)el).getPublication());
            } else if (el.getCategory().equals("Letter")) {
                letter = el;
                assertNotNull(((Letter)el).getRecipient());
                assertNotNull(((Letter)el).getSender());
            } else if(el.getCategory().equals("Microfilm")){
                microfilm = el;
                assertNotNull(((Microfilm)el).getDuration());
                assertNotNull(((Microfilm)el).getFormat());
            }
        }

        // Проверяю что проверена структура всех элемантом библиотеки
        assertNotNull(book);
        assertNotNull(journal);
        assertNotNull(letter);
        assertNotNull(microfilm);
    }

}
