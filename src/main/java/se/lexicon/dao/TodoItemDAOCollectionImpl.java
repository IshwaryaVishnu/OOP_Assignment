package se.lexicon.dao;

import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TodoItemDAOCollectionImpl implements TodoItemDAO {
    private List<TodoItem> userStorage;
    private List<TodoItem> completedList;
    private List<TodoItem> overDueList;
    private List<TodoItem> notOverDueList;

    public TodoItemDAOCollectionImpl()
    {
        userStorage = new ArrayList<TodoItem>();
        completedList = new ArrayList<TodoItem>();
        overDueList = new ArrayList<TodoItem>();
        notOverDueList = new ArrayList<TodoItem>();
    }

    @Override
    public TodoItem findById(int id) {
        for (TodoItem todoItem : userStorage)
            if (todoItem.getId() == id)
                return todoItem;
        return null;
    }

    @Override
    public List<TodoItem> findAll() {
        return new ArrayList<>(userStorage);
    }

    @Override
    public void remove(int id) {
        TodoItem result = findById(id);
        if (result != null)
            userStorage.remove(result);
        throw new IllegalArgumentException("Todoitem is not available in the collection");
    }

    @Override
    public List<TodoItem> findAllByDoneStatus(Boolean done) {
        for (TodoItem todoItem : userStorage)
            if (todoItem.isDone())
                completedList.add(todoItem);

        return completedList;
    }

    @Override
    public List<TodoItem> findByDeadlineAfter(LocalDate date) {
        for (TodoItem todoItem : userStorage)
            if (todoItem.isOverDue())
                overDueList.add(todoItem);

        return  overDueList;
    }

    @Override
    public TodoItem persist(TodoItem todoItem) {
        if (todoItem == null) throw new IllegalArgumentException("TodoItem was null");
        TodoItem result = findById(todoItem.getId());
        if (result != null) throw new IllegalArgumentException("TodoItem was duplicate");
        userStorage.add(todoItem);
        return todoItem;
    }

    @Override
    public List<TodoItem> findByDeadlineBefore(LocalDate date) {
        for (TodoItem item : userStorage)
            if (item.getDeadLine() == date)
                notOverDueList.add(item);

        return notOverDueList;
    }

    @Override
    public List<TodoItem> findByTitleContains(String title) {
        List<TodoItem> todoItems = new ArrayList<TodoItem>();
        for (TodoItem item : userStorage)
            if (item.getTitle().contains(title))
                todoItems.add(item);

        return todoItems;
    }
}
