package se.lexicon;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class TodoItemTest {
    @Test
    public void GetSummaryTest()
    {
        Person person = new Person(1, "ishu", "sankar", "ishu27.v@gmail.com");
        TodoItem toDo =
                new TodoItem(1,"Java Assignment","Complete the assignments for this week",person, LocalDate.now());
        String expectedResult = "id:1  title: Java Assignment  taskDescription: Complete the assignments for this week  deadLine:2022-11-06 Done: false creator: ishu";
        String actualResult = toDo.getSummary();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void OverdueAssignmentTest()
    {
        Person person = new Person(1, "ishu", "sankar", "ishu27.v@gmail.com");
        TodoItem toDo =
                new TodoItem(1,"Java Assignment","Complete the assignments for this week",person, LocalDate.now().minusDays(1));
        boolean isOverdue = toDo.isOverDue();
        Assert.assertTrue(isOverdue);
    }

    @Test
    public void NotOverdueAssignmentTest()
    {
        Person person = new Person(1, "ishu", "sankar", "ishu27.v@gmail.com");
        TodoItem toDo =
                new TodoItem(1,"Java Assignment","Complete the assignments for this week",person, LocalDate.now().plusDays(1));
        boolean isOverdue = toDo.isOverDue();
        Assert.assertFalse(isOverdue);
    }
}
