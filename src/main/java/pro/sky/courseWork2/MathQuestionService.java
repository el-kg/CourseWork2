package pro.sky.courseWork2;

import org.springframework.stereotype.Service;;
import pro.sky.courseWork2.exception.NotEnoughQuestionException;
import pro.sky.courseWork2.repository.MathQuestionRepository;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {
    private final MathQuestionRepository mathQuestions = new MathQuestionRepository();
    private final Random rnd = new Random();

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        return mathQuestions.add(question1);
    }

    @Override
    public Question add(Question question) {
        mathQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        mathQuestions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestions.getAll();
    }


    @Override
    public Question getRandomQuestion() {
        if (mathQuestions.getAll().isEmpty()) {
            throw new NotEnoughQuestionException();
        }
        int random = rnd.nextInt(mathQuestions.getAll().size());
        return (Question) mathQuestions.getAll().toArray()[random];

    }
}

