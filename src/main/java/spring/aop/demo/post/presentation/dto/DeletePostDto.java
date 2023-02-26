package spring.aop.demo.post.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class DeletePostDto {
	@Getter
	@AllArgsConstructor
	public static class ResponseForm {
		private Long id;
	}
}
