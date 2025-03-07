package hello.thymeleaf.api;

import hello.thymeleaf.exception.UserException;
import hello.thymeleaf.exhandler.ErrorResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ApiExceptionV2Controller {



    @GetMapping("/api2/members/{id}")
    public MemberDto getMember(@PathVariable("id") String id){

        switch (id) {
            case "ex" -> throw new RuntimeException("잘못된 사용자");
            case "bad" -> throw new IllegalArgumentException("잘못된 입력 값");
            case "user-ex" -> throw new UserException("사용자 오류");
        }

        return new MemberDto(id, "hello " + id);
    }





    @Data
    @AllArgsConstructor
    static class MemberDto{
        private String memberId;
        private String name;
    }



}
