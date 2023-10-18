package pro.sky.courseWork2.repository;

import pro.sky.courseWork2.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MathQuestionRepository implements QuestionRepository {
    private final Set<Question> mathQuestions = new HashSet<>();

    public MathQuestionRepository()  {
    }

    @PostConstruct
    public void init(){
        int amount=5;
        int i=0;
        while(mathQuestions.size()<amount){
            String question="mathQuestion"+i;
            String answer="mathAnswer"+i;
            mathQuestions.add(new Question(question,answer));
            i++;
        }
    }
    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        return add(question1);
    }
    @Override
    public Question add(Question question) {
        mathQuestions.add(question);
        return question;}
    @Override
    public Question remove(Question question) {
        mathQuestions.remove(question);
        return question;
    }
    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(mathQuestions);
    }
}
