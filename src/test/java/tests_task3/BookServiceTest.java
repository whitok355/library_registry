package tests_task3;

import org.example.task3.BookingService;
import org.example.task3.CantBookException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {
    private static Logger log;
    @BeforeAll
    public static void init(){
        log = LoggerFactory.getLogger(BookServiceTest.class);
    }

    @ParameterizedTest
    @CsvSource({
            "user1, 2023-04-01T10:00, 2023-04-01T11:00",
    })
    public void checkBookAvailable(String user, LocalDateTime from, LocalDateTime to) throws CantBookException {
        log.info("Старт теста checkBookAvailable");

        BookingService bookingServiceSpy = spy(BookingService.class);
        log.debug("Mock объект для класса " + this.getClass().getSimpleName() + "создан");

        log.debug("Условие для метода createBook создано");
        when(bookingServiceSpy.createBook(user, from, to)).thenReturn(true);

        log.debug("Условие для метода checkTimeInBD создано");
        when(bookingServiceSpy.checkTimeInBD(from, to)).thenReturn(true);

        assertTrue(bookingServiceSpy.book(user, from, to));

        verify(bookingServiceSpy).createBook(user, from, to);
        verify(bookingServiceSpy).checkTimeInBD(from, to);
        verify(bookingServiceSpy).book(user, from, to);

    }

    @ParameterizedTest
    @CsvSource({
            "user1, 2023-04-01T10:00, 2023-04-01T11:00",
    })
    public void checkBookUnavailable(String user, LocalDateTime from, LocalDateTime to) throws CantBookException {
        log.info("Старт теста checkBookUnavailable");

        BookingService bookingServiceSpy = spy(BookingService.class);
        log.debug("Mock объект для класса " + this.getClass().getSimpleName() + "создан");

        when(bookingServiceSpy.checkTimeInBD(from, to)).thenReturn(false);
        log.debug("Условие для метода checkTimeInBD создано");

        assertThrows(CantBookException.class, ()-> bookingServiceSpy.book(user, from,to));

        verify(bookingServiceSpy).checkTimeInBD(from, to);
        verify(bookingServiceSpy).book(user, from, to);
        verify(bookingServiceSpy, times(0)).createBook(user, from, to);
    }

    @ParameterizedTest
    @CsvSource({
            "user1, 2023-04-01T10:00, 2023-04-01T11:00",
    })
    public void checkErrorWhenCreateBook(String userid, LocalDateTime from, LocalDateTime to) throws CantBookException {
        log.info("Старт теста checkErrorWhenCreateBook");

        BookingService bookingService = spy(BookingService.class);
        log.debug("Mock объект для класса " + this.getClass().getSimpleName() + "создан");

        when(bookingService.checkTimeInBD(from , to)).thenReturn(true);
        log.debug("Условие для метода checkTimeInBD создано");

        when(bookingService.createBook(userid, from, to)).thenReturn(false);
        log.debug("Условие для метода createBook создано");

        assertFalse(bookingService.book(userid, from,to));

        verify(bookingService).checkTimeInBD(from, to);
        verify(bookingService).createBook(userid, from, to);
        verify(bookingService).book(userid, from, to);
    }

}
