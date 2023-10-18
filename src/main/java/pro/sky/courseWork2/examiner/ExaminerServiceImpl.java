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
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (javaQuestionService.getAll().size()+mathQuestionService.getAll().size() < amount) {
            throw new NotEnoughQuestionException();
        }
        int javaAmount = random.nextInt(amount);
        int mathAmount = amount-javaAmount;
        Set<Question> userQuestionSet = new HashSet<>();
        while (userQuestionSet.size() < javaAmount) {
            userQuestionSet.add(javaQuestionService.getRandomQuestion());
        }
        while (userQuestionSet.size() < mathAmount) {
            userQuestionSet.add(javaQuestionService.getRandomQuestion());
        }
        return userQuestionSet;
    }
}
