package spring.aop.demo.post.service;

import spring.aop.demo.post.presentation.dto.DeletePostDto;
import spring.aop.demo.post.presentation.dto.ReadPostDto;
import spring.aop.demo.post.presentation.dto.UpdatePostDto;
import spring.aop.demo.post.presentation.dto.WritePostDto;

public interface PostUseCase {
	WritePostDto.ResponseForm write(WritePostDto.RequestForm request);
	ReadPostDto.ResponseForm read(Long postId);
	UpdatePostDto.ResponseForm update(Long postId,
		UpdatePostDto.RequestForm request);
	DeletePostDto.ResponseForm delete(Long postId);
}
