package se.lexicon;
import java.time.LocalDate;

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
    public String getSummary(){ return "id:" + id + "  title: " + title + "  taskDescription: " + taskDescription + "  deadLine:" + deadLine +  " Done: " + done + " creator: " + creator.getFirstName();}

}



