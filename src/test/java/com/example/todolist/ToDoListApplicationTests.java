package com.example.todolist;

import com.example.todolist.Model.Member;
import com.example.todolist.Service.LoginService;
import com.example.todolist.dao.LoginRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class ToDoListApplicationTests {

	@Mock
	LoginRepo loginRepo;

	@InjectMocks
	LoginService loginService;

	@Test
	public void 회원가입테스트(){
		//given
		String id = "sku";
		String pw = "1234";
		Member expectedMember = new Member("Han", id, pw);
		loginRepo.save(expectedMember);

		when(loginRepo.findById("sku")).thenReturn(of(expectedMember));

		//when
		Member actualMember = loginService.login(id, pw);
		//assert
		assertThat(actualMember).isEqualTo(expectedMember);
	}
}
