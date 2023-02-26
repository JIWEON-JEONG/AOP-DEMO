package spring.aop.demo.global.querycounter.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

import org.springframework.web.context.request.RequestContextHolder;

import spring.aop.demo.global.querycounter.ApiQueryCounter;

public class PreparedStatementProxyHandler implements InvocationHandler {

	private final Object preparedStatement;
	private final ApiQueryCounter apiQueryCounter;

	/**
	 * 인자로 들어오는 connection 은 같아야 하기 때문에 final 적용.
	 */
	public PreparedStatementProxyHandler(final Object preparedStatement, final ApiQueryCounter apiQueryCounter) {
		this.preparedStatement = preparedStatement;
		this.apiQueryCounter = apiQueryCounter;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (isExecuteQuery(method) && isInRequestScope()) {
			apiQueryCounter.increaseCount();
		}
		return method.invoke(preparedStatement, args);
	}

	private boolean isExecuteQuery(final Method method) {
		String methodName = method.getName();
		return methodName.equals("executeQuery") || methodName.equals("execute") || methodName.equals("executeUpdate");
	}

	//@todo requestScope 들어있는지 확인 방법
	private boolean isInRequestScope() {
		return Objects.nonNull(RequestContextHolder.getRequestAttributes());
	}
}
