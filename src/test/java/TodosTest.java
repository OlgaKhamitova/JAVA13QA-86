import org.example.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);


        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_search_simpleTask() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(5,"позвонить"));
        Task[] expectedTasks = {new SimpleTask(5,"позвонить")};
        Task[] actualTask = todos.search("позвонить");

        Assertions.assertArrayEquals(expectedTasks, actualTask);
    }


    @Test
    public void test_search_meeting() {
        Todos todos = new Todos();
        todos.add(new Meeting(5,"работа", "java", "понедельник"));
        Task[] expected= {new Meeting(5, "работа", "java", "понедельник")};
        Task[] actual = todos.search("java");

        Assertions.assertArrayEquals(expected, actual);
    }
}
