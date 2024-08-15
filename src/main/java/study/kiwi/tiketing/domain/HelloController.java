package study.kiwi.tiketing.domain;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.kiwi.tiketing.global.common.BaseResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class HelloController {

    @GetMapping("/")
    public BaseResponse<String> hello() {
        return new BaseResponse("hello");
    }

    @GetMapping("/param")
    public BaseResponse<String> param(@RequestParam LocalDateTime dateTime) {
        return BaseResponse.of(dateTime.toString());
    }

    @GetMapping("/param2")
    public BaseResponse<String> param(@RequestParam LocalDate date) {
        return BaseResponse.of(date.toString());
    }
}
