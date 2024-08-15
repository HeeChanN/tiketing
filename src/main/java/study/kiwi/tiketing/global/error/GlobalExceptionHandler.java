package study.kiwi.tiketing.global.error;


import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import study.kiwi.tiketing.global.common.BaseResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 지원하지 않는 HTTP Method로 요청시 발생
     * */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public BaseResponse<Void> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return new BaseResponse<Void>(ErrorCode.METHOD_NOT_ALLOWED);
    }
    /**
     * 파라미터의 타입이 일치하지 않을시 발생
     * */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public BaseResponse<Void> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return new BaseResponse<Void>(ErrorCode.ARGUMENT_TYPE_MISMATCH);
    }
}
