package spring.aop.demo.post.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class DeletePostDto {
	@Getter
	public static class ResponseForm {
		private Long id;
		private Boolean isDeleted;

		@Builder
		public ResponseForm(Long id, Boolean isDeleted) {
			this.id = id;
			this.isDeleted = isDeleted;
		}
	}
}
