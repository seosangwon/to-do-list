package com.example.todolist.domain.posts;

import com.example.todolist.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostsRepository  extends JpaRepository<Posts,Long> { //Post랑 PK 필요

   // @Query("")
  // List<Posts> findAllDesc(); // Posts 테이블 내 모든 데이터 조회 후, ID를 내림차순로 정렬하여 return
}
