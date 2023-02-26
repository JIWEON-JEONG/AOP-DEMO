package spring.aop.demo.global.querycounter.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import spring.aop.demo.global.querycounter.ApiQueryCounter;

public class ConnectionProxyHandler implements InvocationHandler {

	private final Object connection;
	private final ApiQueryCounter apiQueryCounter;

	/**
	 * 인자로 들어오는 connection 은 같아야 하기 때문에 final 적용.
	 */
	public ConnectionProxyHandler(final Object connection, final ApiQueryCounter apiQueryCounter) {
		this.connection = connection;
		this.apiQueryCounter = apiQueryCounter;
	}

	@Override
	public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
		Object invokeResponse = method.invoke(connection, args); // (1)
		if (method.getName().equals("prepareStatement")) {
			return Proxy.newProxyInstance(
				invokeResponse.getClass().getClassLoader(),
				invokeResponse.getClass().getInterfaces(),
				new PreparedStatementProxyHandler(invokeResponse, apiQueryCounter)
			);
		}
		return invokeResponse;
	}

}
