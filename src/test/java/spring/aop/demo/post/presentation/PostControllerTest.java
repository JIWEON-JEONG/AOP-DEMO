package spring.aop.demo.post.presentation;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.JsonProcessingException;

import spring.aop.demo.BaseIntegrationTest;
import spring.aop.demo.post.presentation.dto.WritePostDto;

class PostControllerTest extends BaseIntegrationTest {

	@Test
	void 게시물_작성() throws Exception {
		//given
		String title = "title";
		String content = "content";
		WritePostDto.RequestForm requestForm = new WritePostDto.RequestForm(title, content);
		//when
		ResultActions resultActions = mockMvc.perform(post("/v1/boards")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(requestForm))
				.accept(MediaType.APPLICATION_JSON))
			.andDo(print());
		//then
		resultActions
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value(1L));
	}
}