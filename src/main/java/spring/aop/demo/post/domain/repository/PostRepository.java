package spring.aop.demo.post.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.aop.demo.post.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
