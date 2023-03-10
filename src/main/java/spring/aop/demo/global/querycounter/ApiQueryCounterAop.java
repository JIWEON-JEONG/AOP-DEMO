package spring.aop.demo.global.querycounter;

import java.lang.reflect.Proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import spring.aop.demo.global.querycounter.dynamic_proxy.ConnectionProxyHandler;

@Aspect
@Component
public class ApiQueryCounterAop {
	private final ApiQueryCounter apiQueryCounter;

	public ApiQueryCounterAop(final ApiQueryCounter apiQueryCounter) {
		this.apiQueryCounter = apiQueryCounter;
	}

	@Around("execution(* javax.sql.DataSource.getConnection())")
	public Object getConnection(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object connection = proceedingJoinPoint.proceed();
		return Proxy.newProxyInstance(
			connection.getClass().getClassLoader(),
			connection.getClass().getInterfaces(),
			new ConnectionProxyHandler(connection, apiQueryCounter)
		);
	}
}
