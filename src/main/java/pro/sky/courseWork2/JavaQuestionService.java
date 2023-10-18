package pro.sky.courseWork2;

import org.springframework.stereotype.Service;
import pro.sky.courseWork2.exception.NotEnoughQuestionException;
import pro.sky.courseWork2.repository.JavaQuestionRepository;

import java.util.*;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Service
public class JavaQuestionService implements QuestionService {
    private final JavaQuestionRepository javaQuestions = new JavaQuestionRepository();
    private final Random rnd = new Random();

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        return add(question1);
    }

    @Override
    public Question add(Question question) {
        javaQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        javaQuestions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestions.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        if (javaQuestions.getAll().isEmpty()) {
            throw new NotEnoughQuestionException();
        }
        int random = rnd.nextInt(javaQuestions.getAll().size());
        return (Question) javaQuestions.getAll().toArray()[random];

    }
}
