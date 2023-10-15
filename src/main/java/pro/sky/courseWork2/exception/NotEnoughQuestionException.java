package pro.sky.courseWork2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Не достаточно вопросов в хранилище!")
public class NotEnoughQuestionException extends RuntimeException {
    public NotEnoughQuestionException() {
    }

    public NotEnoughQuestionException(String message) {
        super(message);
    }

    public NotEnoughQuestionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughQuestionException(Throwable cause) {
        super(cause);
    }

    public NotEnoughQuestionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
