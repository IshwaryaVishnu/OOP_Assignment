package se.lexicon;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;
import se.lexicon.model.TodoItemTask;

import java.time.LocalDate;

public class TodoItemTaskTest {

    @Test
    public void GetSummaryTest()
    {
        Person person = new Person(1, "ishu", "sankar", "ishu27.v@gmail.com");
        TodoItem toDo =
                new TodoItem(1,"Java Assignment","Complete the assignments for this week",person, LocalDate.now().plusDays(1));
        TodoItemTask todoItem = new TodoItemTask(1, toDo,person);
        String expectedResult = "id:1 Assigned:false ToDoItem:Java Assignment Assignee:ishu";
        String actualResult = todoItem.toString();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
