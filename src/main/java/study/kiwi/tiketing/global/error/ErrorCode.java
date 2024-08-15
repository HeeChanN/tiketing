package study.kiwi.tiketing.global.error;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // Common Error
    INTERNAL_SERVER_ERROR( "C001", "Server Error", DisplayType.POPUP),
    INVALID_INPUT_VALUE("C002", "Invalid Input Value", DisplayType.POPUP),
    METHOD_NOT_ALLOWED("C003", "Invalid HTTP Method", DisplayType.POPUP),
    ARGUMENT_TYPE_MISMATCH("C004", "Argument Type Mismatch", DisplayType.POPUP),
    ;

    private final String code;
    private final String message;
    private final DisplayType type;

    ErrorCode(final String code, final String message, DisplayType type) {
        this.message = message;
        this.code = code;
        this.type = type;
    }
}
