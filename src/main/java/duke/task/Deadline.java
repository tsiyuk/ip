package duke.task;

import duke.Parser;
import duke.Ui;

import java.time.LocalDateTime;

/**
 * This class represents a deadline task.
 */

public class Deadline extends Task {
    /**
     * Deadline time of the task.
     */
    private final LocalDateTime deadlineTime;

    /**
     * Constructs a Deadline instance using the given description and deadline time.
     *
     * @param description  the given description.
     * @param deadlineTime the given deadline time.
     */
    public Deadline(String description, LocalDateTime deadlineTime) {
        super(description);
        this.deadlineTime = deadlineTime;
    }

    /**
     * Constructs a Deadline instance using the given description, complete state and deadline time.
     *
     * @param description  the given description.
     * @param isDone       the given complete state.
     * @param deadlineTime the given deadline time.
     */
    public Deadline(String description, boolean isDone, LocalDateTime deadlineTime) {
        super(description, isDone);
        this.deadlineTime = deadlineTime;
    }

    /**
     * Returns a string representation of the deadline.
     *
     * @return a string representation of the deadline.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadlineTime.format(Ui.dateTimeFormatter) + ")";
    }

    /**
     * Returns a string representation of the deadline following .txt format.
     *
     * @return a string representation of the deadline following .txt format.
     */
    @Override
    public String toTxtFormat() {
        return "D" + Parser.SPLITER + super.toTxtFormat() +
                Parser.SPLITER + deadlineTime.format(Parser.inputDateTimeFormatter);
    }
}