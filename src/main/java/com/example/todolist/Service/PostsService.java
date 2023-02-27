package com.example.todolist.Service;


import com.example.todolist.Domain.posts.Posts;
import com.example.todolist.Domain.posts.PostsRepository;
import com.example.todolist.dto.PostsResponseDto;
import com.example.todolist.dto.PostsSaveRequestDto;
import com.example.todolist.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 등록,수정,조회
 */

@Service
@RequiredArgsConstructor // private final 자동 생성자
public class PostsService {

    //Autowired 대신 RequiredArgsConstructor로 생성자 주입
    private final PostsRepository postsRepository;



    @Transactional // dto를 entity형태로 저장
    public Long save(PostsSaveRequestDto requestDto){

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).
                orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

 //       posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }


    // DB에서 꺼낸 Entity를 ResponseDto로 바꾼다.
    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다.id="+id));

        return new PostsResponseDto(entity);
    }

}
