package se.lexicon;


import se.lexicon.model.*;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Person person = new Person(1, "ishu", "sankar", "ishu27.v@gmail.com");
        System.out.println(person.toString());

        TodoItem toDo =
                new TodoItem(1,"Java Assignment","Complete the assignments for this week",person, LocalDate.now());
        System.out.println(toDo.toString());

        TodoItemTask todoItem = new TodoItemTask(1, toDo,person);
        System.out.println(todoItem.toString());

        AppUser user = new AppUser("ishu", "1234567", AppRole.ROLE_APP_USER);
        System.out.println(user.toString());


    }
}

