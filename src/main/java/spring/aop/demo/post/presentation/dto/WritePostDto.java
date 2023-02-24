package spring.aop.demo.post.presentation.dto;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class WritePostDto {
	@Getter
	@AllArgsConstructor
	public static class RequestForm {
		@NotNull
		private String title;
		private String content;
	}

	@Getter
	@AllArgsConstructor
	public static class ResponseForm {
		private Long id;
	}
}
