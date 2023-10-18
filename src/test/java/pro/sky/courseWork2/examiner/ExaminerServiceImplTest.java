package pro.sky.courseWork2.examiner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.courseWork2.Question;
import pro.sky.courseWork2.QuestionService;
import pro.sky.courseWork2.exception.NotEnoughQuestionException;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl underTest;

    @Test
    void getQuestions_shouldThrowExceptionWhenNotEnoughQuestion() {
        when(questionService.getAll()).thenReturn(Collections.emptySet());
        assertThrows(NotEnoughQuestionException.class,()-> underTest.getQuestions(1));
    }
    @Test
    void getQuestions_shouldReturnUniqueQuestionsCollection() {
        int amount=2;
        Question question = new Question("Как дела?", "Норм");
        Question question1 = new Question("Есть закурить?", "Не курю!");
        Set<Question> expectedSet= Set.of(question,question1);
        when(questionService.getAll()).thenReturn(expectedSet);
        when(questionService.getRandomQuestion()).thenReturn(question,question1);
        Collection<Question> result = underTest.getQuestions(amount);
        assertEquals(expectedSet,result);
        assertEquals(amount,result.stream().distinct().count());
    }
}