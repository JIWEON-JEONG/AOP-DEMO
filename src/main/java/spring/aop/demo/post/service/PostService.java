package spring.aop.demo.post.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import spring.aop.demo.post.domain.Post;
import spring.aop.demo.post.domain.repository.PostRepository;
import spring.aop.demo.post.presentation.dto.ReadPostDto;
import spring.aop.demo.post.presentation.dto.UpdatePostDto;
import spring.aop.demo.post.presentation.dto.WritePostDto;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService implements PostUseCase {

	private final PostRepository postRepository;

	@Transactional(readOnly = true)
	@Override
	public ReadPostDto.ResponseForm read(Long postId) {
		Optional<Post> wrappedPost = postRepository.findById(postId);
		Post post = validateIfExist(wrappedPost);

		return ReadPostDto.ResponseForm.builder()
			.id(post.readPrimaryKey())
			.title(post.readTitle())
			.content(post.readContent())
			.build();
	}

	@Override
	public WritePostDto.ResponseForm write(WritePostDto.RequestForm request) {
		Post post = Post.builder()
			.title(request.getTitle())
			.content(request.getContent())
			.build();
		Long postId = postRepository.save(post).readPrimaryKey();

		return new WritePostDto.ResponseForm(postId);
	}

	@Override
	public UpdatePostDto.ResponseForm update(Long postId, UpdatePostDto.RequestForm request) {
		Optional<Post> wrappedPost = postRepository.findById(postId);
		Post post = validateIfExist(wrappedPost);
		post.update(request.getTitle(), request.getContent());

		return UpdatePostDto.ResponseForm.builder()
			.id(post.readPrimaryKey())
			.title(post.readTitle())
			.content(post.readContent())
			.build();
	}

	private Post validateIfExist(Optional<Post> post) {
		post.orElseThrow(() -> new RuntimeException("404 PostNotFound"));
		return post.get();
	}
}
