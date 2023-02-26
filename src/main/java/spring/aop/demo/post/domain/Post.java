package spring.aop.demo.post.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "VARCHAR(100)")
	@NotNull
	private String title;

	@Column(columnDefinition = "TEXT")
	private String content;

	@Column
	private Boolean isDeleted = Boolean.FALSE;

	@Builder
	public Post(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public Long readPrimaryKey() {
		return this.id;
	}

	public String readTitle() {
		return this.title;
	}

	public String readContent() {
		return this.content;
	}

	public Boolean isDeleted() {
		return this.isDeleted;
	}

	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public void delete() {
		this.isDeleted = Boolean.TRUE;
	}
}
