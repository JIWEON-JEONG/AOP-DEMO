package spring.aop.demo.post.presentation;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.JsonProcessingException;

import spring.aop.demo.BaseIntegrationTest;
import spring.aop.demo.post.presentation.dto.UpdatePostDto;
import spring.aop.demo.post.presentation.dto.WritePostDto;

class PostControllerTest extends BaseIntegrationTest {

	@Test
	@Order(value = 1)
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

	@Test
	@Order(value = 2)
	void 게시물_업데이트() throws Exception {
		//given
		Long postId = 1L;
		String updateTitle = "updateTitle";
		String updateContent = "updateContent";
		UpdatePostDto.RequestForm requestForm = new UpdatePostDto.RequestForm(updateTitle, updateContent);
		//when
		ResultActions resultActions = mockMvc.perform(put("/v1/boards/" + postId)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(requestForm))
				.accept(MediaType.APPLICATION_JSON))
			.andDo(print());
		//then
		resultActions
			.andExpect(status().isOk())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value(1L))
			.andExpect(jsonPath("$.title").value(updateTitle))
			.andExpect(jsonPath("$.content").value(updateContent));
	}

	@Test
	@Order(value = 3)
	void 게시물_읽기() throws Exception {
		//given
		Long postId = 1L;
		//when
		ResultActions resultActions = mockMvc.perform(get("/v1/boards/" + postId)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andDo(print());
		//then
		resultActions
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value(1L))
			.andExpect(jsonPath("$.title").value("updateTitle"))
			.andExpect(jsonPath("$.content").value("updateContent"));
	}
}