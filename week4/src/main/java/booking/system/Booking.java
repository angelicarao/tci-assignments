package booking.system;

import java.time.LocalTime;

public class Booking {
    private LocalTime to;
    private LocalTime from;

    public Booking(LocalTime from, LocalTime to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        if (to != null ? !to.equals(booking.to)
                : booking.to != null) return false;
        if (from != null ? !from.equals(booking.from)
                : booking.from != null) return false;
        return true;
    }
}
