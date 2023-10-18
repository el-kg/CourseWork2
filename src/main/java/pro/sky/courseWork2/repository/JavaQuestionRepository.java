package pro.sky.courseWork2.repository;

import org.springframework.stereotype.Service;
import pro.sky.courseWork2.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
@Service
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> javaQuestions = new HashSet<>();

    public JavaQuestionRepository()  {
    }

   @PostConstruct
    public void init(){
  int amount=5;
          int i=0;
        while(javaQuestions.size()<amount){
            String question="javaQuestion"+i;
            String answer="javaAnswer"+i;
            javaQuestions.add(new Question(question,answer));
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
        javaQuestions.add(question);
        return question;}
    @Override
    public Question remove(Question question) {
        javaQuestions.remove(question);
        return question;
    }
    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(javaQuestions);
    }
}
