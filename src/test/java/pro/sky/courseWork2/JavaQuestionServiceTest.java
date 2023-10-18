package pro.sky.courseWork2;

import org.junit.jupiter.api.Test;
import pro.sky.courseWork2.exception.NotEnoughQuestionException;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private final JavaQuestionService underTest = new JavaQuestionService();
    private final Question question = new Question("Как дела?", "Норм");

    @Test
    void add_shouldAddQuestionToSetAndReturnQuestion() {
        Question result = underTest.add(question.getQuestion(), question.getAnswer());
        assertTrue(underTest.getAll().contains(question));
        assertEquals(question, result);

    }

    @Test
    void remove_shouldRemoveQuestionFromSetAndReturnQuestion() {
        Question result = underTest.remove(question);
        assertFalse(underTest.getAll().contains(question));
        assertEquals(question, result);
    }

    @Test
    void getAll_shouldReturnQuestionsCollection() {
        Question question1 = new Question("Есть закурить?", "Не курю!");
        underTest.add(question);
        underTest.add(question1);
        Collection<Question> result = underTest.getAll();
        assertEquals(Set.of(question, question1), result);
    }

    @Test
    void getRandomQuestion_shouldThrowNotEnoughQuestionException() {
        assertThrows(NotEnoughQuestionException.class,
                () -> underTest.getRandomQuestion());
    }

    @Test
    void getRandomQuestion_shouldReturnQuestionWhenCollectionIsNotEmpty() {
        underTest.add(question);
        Question result = underTest.getRandomQuestion();
        assertEquals(question, result);
    }
}