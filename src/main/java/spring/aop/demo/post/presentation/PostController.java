package spring.aop.demo.post.presentation;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring.aop.demo.post.presentation.dto.ReadPostDto;
import spring.aop.demo.post.presentation.dto.UpdatePostDto;
import spring.aop.demo.post.presentation.dto.WritePostDto;
import spring.aop.demo.post.service.PostUseCase;

@Validated
@RestController
@RequestMapping("/v1/boards")
@RequiredArgsConstructor
public class PostController {
	private final PostUseCase postUseCase;

	@GetMapping("/{postId}")
	public ResponseEntity<ReadPostDto.ResponseForm> readPostApi(@PathVariable @NotNull Long postId) {
		ReadPostDto.ResponseForm response = postUseCase.read(postId);
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<WritePostDto.ResponseForm> writeNewPostApi(
		@Valid @RequestBody WritePostDto.RequestForm request) {
		WritePostDto.ResponseForm response = postUseCase.write(request);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{postId}")
	public ResponseEntity<UpdatePostDto.ResponseForm> updatePostApi(
		@PathVariable @NotNull Long postId,
		@Valid @RequestBody UpdatePostDto.RequestForm request) {
		UpdatePostDto.ResponseForm response = postUseCase.update(postId, request);
		return ResponseEntity.ok(response);
	}
}
