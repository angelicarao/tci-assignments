package booking.system;

import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookingManagerTest {

    private BookingManager bookingManager = new BookingManager();
    private final LocalTime FROM = LocalTime.of(4, 0);
    private final LocalTime TO = LocalTime.of(5, 0);

    @Test
    public void bookingIsAddedCorrectly() {
        bookingManager.makeBooking(FROM, TO);

        assertThat(bookingManager.getBookings().contains(new Booking(FROM, TO)), is(true));
    }
}
