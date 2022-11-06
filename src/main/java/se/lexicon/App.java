package se.lexicon;


import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Person person = new Person(1, "ishu", "sankar", "ishu27.v@gmail.com");
        System.out.println(person.getSummary());

        TodoItem toDo =
                new TodoItem(1,"Java Assignment","Complete the assignments for this week",person, LocalDate.now());
        System.out.println(toDo.getSummary());

        TodoItemTask todoItem = new TodoItemTask(1, toDo,person);
        System.out.println(todoItem.getSummary());


    }
}

