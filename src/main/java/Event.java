import java.time.LocalDateTime;

/**
 * This class represents an event task.
 */

public class Event extends Task{
    /** Start or end time of the event. */
    private LocalDateTime eventTime;

    /**
     * Constructs an event using the given description and event time.
     *
     * @param description the given description
     * @param eventTime the given event time.
     */
    public Event(String description, LocalDateTime eventTime) {
        super(description);
        this.eventTime = eventTime;
    }

    /**
     * Returns a string representation of the event.
     *
     * @return a string representation of the event.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + eventTime.format(CommonUtils.dateTimeFormatter) + ")";
    }
}
