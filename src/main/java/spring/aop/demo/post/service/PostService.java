package spring.aop.demo.post.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import spring.aop.demo.post.domain.Post;
import spring.aop.demo.post.domain.repository.PostRepository;
import spring.aop.demo.post.presentation.dto.WritePostDto;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService implements PostUseCase {

	private final PostRepository postRepository;

	@Override
	public WritePostDto.ResponseForm write(WritePostDto.RequestForm request) {
		Post post = Post.builder()
			.title(request.getTitle())
			.content(request.getContent())
			.build();
		Long postId = postRepository.save(post).readPrimaryKey();

		return new WritePostDto.ResponseForm(postId);
	}
}
