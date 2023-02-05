package james.command;

import james.exception.JamesException;
import james.jamesbot.Storage;
import james.task.TaskList;
import james.jamesbot.Ui;


/**
 * Lists all the tasks in the task list.
 */
public class ListTasksCommand extends Command {
    /**
     * Executes the ListCommand which is to list all tasks stored in user's hard disk.
     *
     * @param tasks The list where tasks are added to.
     * @param ui The ui to print out JamesBot's response.
     * @param storage The task list that is stored in the user's hard disk.
     */
    public String execute (TaskList tasks, Ui ui, Storage storage) {
        return ui.listTasks(tasks);
    }

    /**
     * Returns whether ListCommand exits the program.
     *
     * @return false as ListCommand does not exit the program.
     */
    public boolean isExit() {
        return false;
    }
}
