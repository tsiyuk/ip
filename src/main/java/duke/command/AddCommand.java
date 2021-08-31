package duke.command;

import duke.Action;
import duke.DukeException;
import duke.Parser;
import duke.Storage;
import duke.Ui;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.TaskList;
import duke.task.Todo;

public class AddCommand extends Command {
    private final String info;

    /**
     * Constructs an AddCommand instance using the given action and info.
     *
     * @param action The given action.
     * @param info The given info.
     */
    public AddCommand(Action action, String info) {
        super(action);
        this.info = info;
    }

    @Override
    public void execute(TaskList taskList, Storage storage) {
        switch (super.getAction()) {
        case TODO: {
            Todo temp = new Todo(info);
            taskList.addTask(temp);
            Ui.showAddTaskMessage(temp, taskList.getSize());
            break;
        }
        case DEADLINE: {
            String[] arr = info.split(" /by ");
            if (arr.length == 1) {
                throw new DukeException("/by is needed to specified the time.");
            }
            String description = arr[0];
            String detail = arr[1];
            Deadline temp = new Deadline(description, Parser.parseDateTime(detail));
            taskList.addTask(temp);
            Ui.showAddTaskMessage(temp, taskList.getSize());
            break;
        }
        case EVENT: {
            String[] arr = info.split(" /at ");
            if (arr.length == 1) {
                throw new DukeException("/at is needed to specified the time.");
            }
            String description = arr[0];
            String detail = arr[1];
            Event temp = new Event(description, Parser.parseDateTime(detail));
            taskList.addTask(temp);
            Ui.showAddTaskMessage(temp, taskList.getSize());
            break;
        }
        default:
            throw new DukeException("Error: wrong action type for add command");
        }
    }
}
