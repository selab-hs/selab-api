package kr.ac.hs.selab.error.exception;

import kr.ac.hs.selab.error.template.ErrorMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;

// TODO super에 exception을 추가하여 나중에 있을 stacktrace를 대비한다.
// StackTrace를 가져갈 수 있는 구조로 만들어야 한다.
@Getter
public abstract class BusinessException extends RuntimeException {

    private final ErrorMessage errorMessage;
    private final HttpStatus status;

    public BusinessException(ErrorMessage message, HttpStatus status) {
        super(message.getDetail());
        this.errorMessage = message;
        this.status = status;
    }

    // Cause까지도 관리가 가능하게...
    public BusinessException(ErrorMessage message, HttpStatus status, Throwable cause) {
        super(message.getDetail(), cause);
        this.errorMessage = message;
        this.status = status;
    }
}