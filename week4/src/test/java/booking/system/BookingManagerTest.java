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
    public void bookingIsAddedCorrectly() throws IrregularHourException {
        bookingManager.makeBooking(FROM, TO);

        assertThat(bookingManager.getBookings().contains(new Booking(FROM, TO)), is(true));
    }

    @Test
    public void doubleBookingIsNotAdded() throws IrregularHourException {
        bookingManager.makeBooking(FROM, TO);
        bookingManager.makeBooking(FROM, TO);

        assertThat(bookingManager.getBookings().size(), is(1));
    }

    @Test(expected = IrregularHourException.class)
    public void bookingWithNonWholeHoursThrowsException() throws IrregularHourException {
        bookingManager.makeBooking(LocalTime.of(4, 20), LocalTime.of(5, 15));
    }
}
