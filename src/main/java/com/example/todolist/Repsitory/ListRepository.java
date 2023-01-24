package com.example.todolist.Repsitory;

import com.example.todolist.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ListRepository extends JpaRepository<Member,Long> {

}
