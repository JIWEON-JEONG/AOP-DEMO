package spring.aop.demo.post.presentation.dto;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UpdatePostDto {
	@Getter
	@AllArgsConstructor
	public static class RequestForm {
		@NotNull
		private String title;
		private String content;
	}

	@Getter
	public static class ResponseForm {
		private Long id;
		private String title;
		private String content;

		@Builder
		public ResponseForm(Long id, String title, String content) {
			this.id = id;
			this.title = title;
			this.content = content;
		}
	}
}
