package se.lexicon;

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
    public String getSummary(){return "id:" + id +" Assigned:" + assigned + " ToDoItem:" + todoItem.getTitle() + " Assignee:" + assignee.getFirstName() ;}
}