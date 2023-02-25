package spring.aop.demo.post.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.UUID;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import spring.aop.demo.post.domain.Post;
import spring.aop.demo.post.domain.repository.PostRepository;
import spring.aop.demo.post.presentation.dto.WritePostDto;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PostServiceTest {

	@Mock
	PostRepository postRepository;

	PostUseCase postUseCase;

	@BeforeAll
	void init() {
		postUseCase = new PostService(postRepository);
	}

	@Test
	@DisplayName("게시물 작성 테스트 코드")
	void write() {
		//given
		String title = "title";
		String content = "content";
		Post post = Post.builder()
			.title(title)
			.content(content)
			.build();
		Long postId = 1L;
		ReflectionTestUtils.setField(post, "id", postId);

		//when
		when(postRepository.save(Mockito.any(Post.class)))
			.thenReturn(post);
		WritePostDto.ResponseForm response = postUseCase.write(new WritePostDto.RequestForm(title, content));

		//then
		assertThat(response.getId()).isEqualTo(postId);
	}
}