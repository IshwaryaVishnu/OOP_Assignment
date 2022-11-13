package se.lexicon;

import java.util.Objects;

public class TodoItemTask {
//Fields
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

//Constructors
    public TodoItemTask(){this.assigned = false;}

    public TodoItemTask(int id, TodoItem todoItem, Person assignee){
        this();
        this.id = id;
        this.todoItem =todoItem;
        this.assignee = assignee;
    }
//Getters & Setters

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public boolean isAssigned() { return assigned;}

    public void setAssigned(boolean assigned) {
        setAssignee(assignee);
        this.assigned = assigned;}

    public TodoItem getTodoItem() {
        if(todoItem == null) throw new IllegalArgumentException("ToDoItem cannot be null");
        this.todoItem = todoItem;
        return todoItem;}

    public void setTodoItem(TodoItem todoItem) { this.todoItem = todoItem;}

    public Person getAssignee() { return assignee;}
    public void setAssignee(Person assignee) {
        if(!(assignee == null) )
            this.assignee = assignee;
        this.assigned= true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItemTask)) return false;
        TodoItemTask that = (TodoItemTask) o;
        return getId() == that.getId() && isAssigned() == that.isAssigned() && getTodoItem().equals(that.getTodoItem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isAssigned(), getTodoItem());
    }

    @Override
    public String toString() {
        return "TodoItemTask{" +
                "id=" + id +
                ", assigned=" + assigned +
                ", todoItem=" + todoItem +
                '}';
    }
}