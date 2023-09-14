package ru.netology.Manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(1,"Подготовить изменения к выкатке");

        String[] subtasks = {
                "Подготовить изменения к выкатке",
                "Выкатка на предпродакшн",
                "Выкатка на продакшн",
                "Промониторить и проанализировать",
                "Задокументировать изменения"
        };
        Epic epic = new Epic(5, subtasks);

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
    public void testWhenFewTasksFound() {
        SimpleTask simpleTask = new SimpleTask(1, "Подготовить изменения к выкатке");

        String[] subtasks = {
                "Подготовить изменения к выкатке",
                "Выкатка на предпродакшн",
                "Выкатка на продакшн",
                "Промониторить и проанализировать",
                "Задокументировать изменения"
        };
        Epic epic = new Epic(5, subtasks);

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

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("к выкатке");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetSubtasks() {

        String[] subtasks = {
                "Подготовить изменения к выкатке",
                "Выкатка на предпродакшн",
                "Выкатка на продакшн",
                "Промониторить и проанализировать",
                "Задокументировать изменения"
        };
        Epic epic = new Epic(5, subtasks);

        String[] expected = subtasks;
        String[] actual = epic.getSubtasks();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetId() {

        String[] subtasks = {
                "Подготовить изменения к выкатке",
                "Выкатка на предпродакшн", "Выкатка на продакшн",
                "Промониторить и проанализировать",
                "Задокументировать изменения"
        };
        Epic epic = new Epic(5, subtasks);
        Task task = new Task(5);

        int expected = epic.getId();
        int actual = task.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchInTodos() {
        SimpleTask simpleTask = new SimpleTask(1, "Подготовить изменения к выкатке");

        String[] subtasks = {
                "Подготовить изменения к выкатке",
                "Выкатка на предпродакшн",
                "Выкатка на продакшн",
                "Промониторить и проанализировать",
                "Задокументировать изменения"
        };
        Epic epic = new Epic(5, subtasks);

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
        Task[] actual = todos.search(" ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInSimpleTaskAndEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Подготовить изменения к выкатке");

        String[] subtasks = {
                "Подготовить изменения к выкатке",
                "Выкатка на предпродакшн",
                "Выкатка на продакшн",
                "Промониторить и проанализировать",
                "Задокументировать изменения"
        };
        Epic epic = new Epic(5, subtasks);

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

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search(simpleTask.getTitle());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Подготовить изменения к выкатке");

        String[] subtasks = {
                "Подготовить изменения к выкатке",
                "Выкатка на предпродакшн",
                "Выкатка на продакшн",
                "Промониторить и проанализировать",
                "Задокументировать изменения"
        };
        Epic epic = new Epic(5, subtasks);

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

        Task[] expected = {epic};
        Task[] actual = todos.search("предпродакшн");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingFirst() {
        SimpleTask simpleTask = new SimpleTask(1, "Подготовить изменения к выкатке");

        String[] subtasks = {
                "Подготовить изменения к выкатке",
                "Выкатка на предпродакшн",
                "Выкатка на продакшн",
                "Промониторить и проанализировать",
                "Задокументировать изменения"
        };
        Epic epic = new Epic(5, subtasks);

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

        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getTopic());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingSecond() {
        SimpleTask simpleTask = new SimpleTask(1, "Подготовить изменения к выкатке");

        String[] subtasks = {
                "Подготовить изменения к выкатке",
                "Выкатка на предпродакшн",
                "Выкатка на продакшн",
                "Промониторить и проанализировать",
                "Задокументировать изменения"
        };
        Epic epic = new Epic(5, subtasks);

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

        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getProject());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingThird() {
        SimpleTask simpleTask = new SimpleTask(1, "Подготовить изменения к выкатке");

        String[] subtasks = {
                "Подготовить изменения к выкатке",
                "Выкатка на предпродакшн",
                "Выкатка на продакшн",
                "Промониторить и проанализировать",
                "Задокументировать изменения"
        };
        Epic epic = new Epic(5, subtasks);

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

        Task[] expected = {};
        Task[] actual = todos.search(meeting.getStart());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Подготовить изменение к выкатке");

        String[] subtasks = {
                "Подготовить изменения к выкатке",
                "Выкатка на предпродакшн",
                "Выкатка на продакшн",
                "Промониторить и проанализировать",
                "Задокументировать изменения"
        };
        Epic epic = new Epic(5, subtasks);

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

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("изменение к выкатке");

        Assertions.assertArrayEquals(expected, actual);
    }
}
