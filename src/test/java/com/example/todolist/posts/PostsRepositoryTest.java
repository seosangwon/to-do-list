package com.example.todolist.posts;


import com.example.todolist.domain.posts.Posts;
import com.example.todolist.domain.posts.PostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
       //given
       String title = "테스트 제목";
       String content = "테스트 내용";

       postsRepository.save(Posts.builder()
               .title(title) // title에 title 변수 저장
           //    .content(content) //content는 content 변수 저장
               .build());
       //when
        List<Posts> postList = postsRepository.findAll();

        //then
        Posts posts = postList.get(0); // id=0부터 저장
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
   //     Assertions.assertThat(posts.getContent()).isEqualTo(content);

    }

}
