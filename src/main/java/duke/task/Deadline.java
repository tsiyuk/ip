package duke.task;

import java.time.LocalDateTime;
import java.util.Objects;

import duke.Parser;
import duke.Ui;

/**
 * This class represents a deadline task.
 */
public class Deadline extends Task {
    /** Deadline time of the task. */
    private LocalDateTime deadlineTime;

    /**
     * Constructs a Deadline instance using the given description and deadline time.
     *
     * @param description  The given description.
     * @param deadlineTime The given deadline time.
     */
    public Deadline(String description, LocalDateTime deadlineTime) {
        super(description);
        this.deadlineTime = deadlineTime;
    }

    /**
     * Constructs a Deadline instance using the given description, complete state and deadline time.
     *
     * @param description  The given description.
     * @param isDone       The given complete state.
     * @param deadlineTime The given deadline time.
     */
    public Deadline(String description, boolean isDone, LocalDateTime deadlineTime) {
        super(description, isDone);
        this.deadlineTime = deadlineTime;
    }

    public void setDeadlineTime(LocalDateTime deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public LocalDateTime getDeadlineTime() {
        return this.deadlineTime;
    }

    /**
     * Returns a string representation of the deadline.
     *
     * @return A string representation of the deadline.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadlineTime.format(Ui.DATE_TIME_FORMATTER) + ")";
    }

    /**
     * Returns a string representation of the deadline following .txt format.
     *
     * @return A string representation of the deadline following .txt format.
     */
    @Override
    public String toTxtFormat() {
        return "D" + Parser.SPLITER + super.toTxtFormat()
                + Parser.SPLITER + deadlineTime.format(Parser.INPUT_DATE_TIME_FORMATTER);
    }

    /**
     * Returns true if the given object is equal to this, otherwise false.
     *
     * @param o The given object.
     * @return True if the given object is equal to this, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Deadline deadline = (Deadline) o;
        return super.equals(o) && Objects.equals(deadlineTime, deadline.deadlineTime);
    }
}
