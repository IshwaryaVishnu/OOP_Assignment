package se.lexicon.dao;

import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.List;

public interface TodoItemDAO {
    TodoItem persist(TodoItem person);
    TodoItem findById(int id);
    List<TodoItem> findAll();
    List<TodoItem> findAllByDoneStatus(Boolean done);
    List<TodoItem> findByTitleContains(String title);
    List<TodoItem> findByDeadlineBefore(LocalDate date);
    List<TodoItem> findByDeadlineAfter(LocalDate date);
    void remove(int id);
}
