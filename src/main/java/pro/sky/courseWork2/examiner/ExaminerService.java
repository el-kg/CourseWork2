package pro.sky.courseWork2.examiner;

import pro.sky.courseWork2.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
