package se.lexicon.model;
import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    //Fields
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private Boolean done;
    private Person creator;

    //Constructors

    public TodoItem(){ this.done = false ;}

    public TodoItem(int id,String title,String taskDescription,Person creator,LocalDate deadLine) {

        this();
        this.id = id;
        this.title = title;
        this.taskDescription = taskDescription;
        this.deadLine= deadLine;
        this.creator = creator;

    }
    //Getters & Setters

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getTitle(){ return title;}

    public void setTitle(String title) {
        if(title == null) throw new IllegalArgumentException("Title cannot be null");
        this.title = title;
    }
    public String getTaskDescription() { return taskDescription;}

    public void setTaskDescription(String taskDescription) { this.taskDescription = taskDescription;}

    public LocalDate getDeadLine() { return deadLine;}

    public void setDeadLine(LocalDate deadLine) { this.deadLine = deadLine;}

    public void setDone(Boolean done) { this.done = done;}

    public boolean isDone(){return done;}

    public Person getCreator() { return creator;}

    public void setCreator(Person creator) { this.creator = creator;}

    public boolean isOverDue(){
        if (this.deadLine.isBefore(LocalDate.now()))
            return true;

        return false;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", deadLine=" + deadLine +
                ", done=" + done +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItem)) return false;
        TodoItem todoItem = (TodoItem) o;
        return getId() == todoItem.getId() && getTitle().equals(todoItem.getTitle()) && Objects.equals(getTaskDescription(), todoItem.getTaskDescription()) && getDeadLine().equals(todoItem.getDeadLine()) && Objects.equals(isDone(), todoItem.isDone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getTaskDescription(), getDeadLine(), isDone());
    }
}



