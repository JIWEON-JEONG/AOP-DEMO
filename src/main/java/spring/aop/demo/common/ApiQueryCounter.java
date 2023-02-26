package spring.aop.demo.common;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import lombok.Getter;

/**
 * RequestScope : 웹 브라우저로부터 WAS가 요청을 받은 후, 포워드 되는 동안 유지하고 싶은 정보가 있을 경우 사용.
 *
 * count field 는 API 응답이 나가고 호출이 종료되면 기존에 있는 값들은 파괴.
 */
@Getter
@Component
@RequestScope
public class ApiQueryCounter {
	private int count;

	public void increaseCount() {
		this.count++;
	}
}
