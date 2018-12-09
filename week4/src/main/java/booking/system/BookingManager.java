package booking.system;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookings;

    public BookingManager() {
        this.bookings = new ArrayList<>();
    }

    /**
     * Creates a booking in the system.
     * @param from The time the booking should start from.
     * @param to The time the booking ends.
     */
    public void makeBooking(LocalTime from, LocalTime to) {
        bookings.add(new Booking(from, to));
    }

    /**
     * Gets the list of all bookings for today.
     * @return
     */
    public List<Booking> getBookings() {
        return this.bookings;
    }
}
