package booking.system;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookingManager {
    private Set<Booking> bookings;

    public BookingManager() {
        this.bookings = new HashSet<>();
    }

    /**
     * Creates a booking in the system.
     *
     * @param from The time the booking should start from.
     * @param to   The time the booking ends.
     */
    public void makeBooking(LocalTime from, LocalTime to) throws IrregularHourException {
        if (from.getMinute() != 0 || to.getMinute() != 0) {
            throw new IrregularHourException();
        } else {
            bookings.add(new Booking(from, to));
        }
    }

    /**
     * Gets the list of all bookings for today.
     *
     * @return
     */
    public Set<Booking> getBookings() {
        return this.bookings;
    }
}
