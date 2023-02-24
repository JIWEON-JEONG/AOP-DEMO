package spring.aop.demo.post.presentation;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring.aop.demo.post.presentation.dto.WritePostDto;
import spring.aop.demo.post.service.PostUseCase;

@RestController
@RequestMapping("/v1/board")
@RequiredArgsConstructor
public class PostController {
	private final PostUseCase postUseCase;

	@PostMapping
	public ResponseEntity<WritePostDto.ResponseForm> writeNewPostApi(
		@Valid @RequestBody WritePostDto.RequestForm request
	) {
		WritePostDto.ResponseForm response = postUseCase.write(request);
		return ResponseEntity.ok(response);
	}
}
