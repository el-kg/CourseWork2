package pro.sky.courseWork2.examiner;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.courseWork2.Question;
import pro.sky.courseWork2.QuestionService;
import pro.sky.courseWork2.exception.NotEnoughQuestionException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Random random = new Random();
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new NotEnoughQuestionException();
        }
        Set<Question> userQuestionSet = new HashSet<>();
        while (userQuestionSet.size() < amount) {
            userQuestionSet.add(questionService.getRandomQuestion());
        }
        return userQuestionSet;
    }
}
