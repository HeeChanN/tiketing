package study.kiwi.tiketing.global.common;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.kiwi.tiketing.global.error.ErrorCode;

@JsonInclude(JsonInclude.Include.NON_NULL) // null은 Json 변환 x
@NoArgsConstructor
@Getter
@JsonPropertyOrder({"isSuccess", "data", "error"})
public class BaseResponse<T> {

    @JsonProperty("isSuccess")
    private Boolean isSuccess;

    @JsonProperty("data")
    private T data;

    @JsonProperty("error")
    private ErrorCode error;

    public BaseResponse(T data) {
        this.isSuccess = Boolean.TRUE;
        this.data = data;
    }

    public BaseResponse(ErrorCode error) {
        this.isSuccess = Boolean.FALSE;
        this.error = error;
    }

    public static <T> BaseResponse<T> of(T data){
        return new BaseResponse<>(data);
    }
}
