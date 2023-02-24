package spring.aop.demo.post.service;

import spring.aop.demo.post.presentation.dto.WritePostDto;

public interface PostUseCase {
	WritePostDto.ResponseForm write(WritePostDto.RequestForm request);
}
