import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.rifu.interceptor.LoginInterceptor;
import com.rifu.service.WeatherService;
import com.rifu.service.impl.WeatherServiceImpl;

/**
 * ±©Â¶·þÎñµÄserver
 * @author Lifu
 *
 */
public class WebServer {
	public static void main(String[] args) {
		String address="http://192.168.1.102:12345/weather";
		JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
		factoryBean.setServiceClass(WeatherService.class);
		factoryBean.setServiceBean(new WeatherServiceImpl());
		factoryBean.setAddress(address);
		factoryBean.getInInterceptors().add(new LoggingInInterceptor());
		factoryBean.getInInterceptors().add(new LoginInterceptor());
		factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
		factoryBean.create();
		System.out.println("publish success...service is open");
	}
}
