package se.lexicon.dao;

import se.lexicon.model.TodoItem;
import se.lexicon.model.TodoItemTask;

import java.util.ArrayList;
import java.util.List;

public class TodoItemTaskDAOCollectionImpl implements TodoItemTaskDAO{

    private List<TodoItemTask> todoItemTasks;

    private List<TodoItemTask> assignedTasks;

    public TodoItemTaskDAOCollectionImpl()
    {
        todoItemTasks = new ArrayList<TodoItemTask>();
        assignedTasks = new ArrayList<TodoItemTask>();
    }

    @Override
    public TodoItemTask findById(int id) {
        for (TodoItemTask item : todoItemTasks)
            if (item.getId() == id)
                return item;
        return null;
    }

    @Override
    public List<TodoItemTask> findAll() {
        return new ArrayList<>(todoItemTasks);
    }

    @Override
    public void remove(int id) {
        TodoItemTask result = findById(id);
        if (result != null)
            todoItemTasks.remove(result);
        throw new IllegalArgumentException("Todoitemtask is not available in the collection");
    }

    @Override
    public TodoItemTask persist(TodoItemTask itemTask) {
        if (itemTask == null) throw new IllegalArgumentException("TodoItem was null");
        TodoItemTask result = findById(itemTask.getId());
        if (result != null) throw new IllegalArgumentException("TodoItem was duplicate");
        todoItemTasks.add(itemTask);
        return itemTask;
    }

    @Override
    public List<TodoItemTask> findAllByAssignedStatus(Boolean status) {
        for (TodoItemTask task : todoItemTasks)
            if (task.isAssigned())
                assignedTasks.add(task);

        return assignedTasks;
    }

    @Override
    public List<TodoItemTask> findByPersonId(int personId) {
        List<TodoItemTask> tasks = new ArrayList<TodoItemTask>();
        for (TodoItemTask task : todoItemTasks)
            if (task.getAssignee().getId() == personId)
                tasks.add(task);

        return tasks;
    }
}
