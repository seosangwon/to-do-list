package com.example.todolist.Controller;

// import com.example.todolist.Repsitory.MemoryMemberRepository; // memberRepository Null Point Exception 때문에 잠시 주석 처리
import com.example.todolist.Service.PostsService;
import com.example.todolist.dto.PostsResponseDto;
import com.example.todolist.dto.PostsSaveRequestDto;
import com.example.todolist.dto.PostsUpdateRequestDto;
        import lombok.RequiredArgsConstructor;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor// private final 생성자 자동 생성
public class PostsController {

    private final PostsService postsService;



    // posts 등록 api
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){

        return postsService.save(requestDto);
    }


    //posts update
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){

        return postsService.update(id, requestDto);

    }
     //id로 찾은 Posts Entity를 service가 responseDto로 바꿔서 준다.
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){

        return postsService.findById(id);
    }


    //기본 컨트롤러 테스트
    @GetMapping("/hello")
    public String hello(){

        return "hello";
    }

}
