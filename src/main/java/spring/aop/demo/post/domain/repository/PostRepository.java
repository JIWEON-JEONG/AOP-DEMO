package spring.aop.demo.post.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import spring.aop.demo.post.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	@Query("SELECT p FROM Post p WHERE p.id = :id and p.isDeleted = false")
	Optional<Post> findByPrimaryKey(@Param("id") Long primaryKey);
}
