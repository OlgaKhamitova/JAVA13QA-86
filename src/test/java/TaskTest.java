import org.example.Epic;
import org.example.Meeting;
import org.example.SimpleTask;
import org.example.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testMeetingMatches() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Приложение");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_SimpleTaskMatches() {
        Task simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean expected = true;
        boolean actual = simpleTask.matches("родителям");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_EpicMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Task epic = new Epic(55, subtasks);
        boolean expected = true;
        boolean actual = epic.matches("Яйца");
        Assertions.assertEquals(expected, actual);
    }

}
