package duke.command;

import duke.Action;
import duke.Storage;
import duke.task.TaskList;

public abstract class Command {
    private final Action action;
    private final boolean isExit;

    /**
     * Constructs a command instance using the given action and set isExit to false.
     *
     * @param action The given action.
     */
    public Command(Action action) {
        this.action = action;
        this.isExit = false;
    }

    /**
     * Constructs a command instance using the given action and isExit state.
     *
     * @param action The given action.
     * @param isExit The given isExit state.
     */
    public Command(Action action, boolean isExit) {
        this.action = action;
        this.isExit = isExit;
    }

    /**
     * Returns the isExit status.
     *
     * @return The isExit status.
     */
    public boolean isExit() {
        return isExit;
    }

    /**
     * Returns the action of the command.
     *
     * @return The action of the command.
     */
    public Action getAction() {
        return action;
    }

    /**
     * Executes the command and prints the result in console.
     *
     * @param taskList The task list of duke.
     * @param storage The local storage of duke.
     */
    public abstract void executeAndShow(TaskList taskList, Storage storage);

    /**
     * Returns the result of executing the command.
     *
     * @param taskList The task list of duke.
     * @param storage The local storage of duke.
     * @return A string representation of the result.
     */
    public abstract String execute(TaskList taskList, Storage storage);
}
