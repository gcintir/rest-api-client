package restapiclient.restapiclient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class RestApiClientApplication implements CommandLineRunner {

	@Autowired
	RestApiRequestHandler restApiRequestHandler;

	public static void main(String[] args) {
		SpringApplication.run(RestApiClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//test1();
		/*test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
		test9();
		test10();
		test11();


	test12(); */

		test12();
	}

	public void test1() throws RestApiRequestHandlerException {
		String r = restApiRequestHandler.sendRequest("http://localhost:8090/test1", HttpMethod.GET, String.class);

		System.out.println(r);

	}

	public void test2() throws RestApiRequestHandlerException {

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

		String r = restApiRequestHandler.sendRequest("http://localhost:8090/test1", HttpMethod.GET, requestHeaders, String.class);

		System.out.println(r);

	}

	public void test3()throws RestApiRequestHandlerException  {
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		String r = restApiRequestHandler.sendRequest("http://localhost:8090/test1", HttpMethod.GET, requestHeaders, String.class);
		System.out.println(r);
	}

	public void test4() throws RestApiRequestHandlerException {
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		String r = restApiRequestHandler.sendRequest("http://localhost:8090/test2/5", HttpMethod.GET, requestHeaders, String.class);
		System.out.println(r);
	}

	public void test5() throws RestApiRequestHandlerException {
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		String r = restApiRequestHandler.sendRequest("http://localhost:8090/test3?id=66", HttpMethod.GET, requestHeaders, String.class);
		System.out.println(r);
	}

	public void test6() throws RestApiRequestHandlerException {
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		String r = restApiRequestHandler.sendRequest("http://localhost:8090/test4?id=66&name=gg", HttpMethod.GET, requestHeaders, String.class);
		System.out.println(r);
	}

	public void test7() throws RestApiRequestHandlerException {
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		String r = restApiRequestHandler.sendRequest("http://localhost:8090/test5?id=66&name=gg", HttpMethod.POST, requestHeaders, String.class);
		System.out.println(r);
	}

	public void test8() throws RestApiRequestHandlerException {

		Person p = new Person();
		p.setId(2L);p.setName("p1");
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		String r = restApiRequestHandler.sendRequest("http://localhost:8090/test6", HttpMethod.POST, requestHeaders, p, String.class);
		System.out.println(r);
	}

	public void test9() throws RestApiRequestHandlerException {

		Person p = new Person();
		p.setId(2L);p.setName("p1");
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		String r = restApiRequestHandler.sendRequest("http://localhost:8090/test7?id=66", HttpMethod.POST, requestHeaders, p, String.class);
		System.out.println(r);
	}

	public void test10() throws RestApiRequestHandlerException {

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		requestHeaders.put("processId", "1111111");
		String r = restApiRequestHandler.sendRequest("http://localhost:8090/test8", HttpMethod.POST, requestHeaders, String.class);
		System.out.println(r);
	}

	public void test11() throws RestApiRequestHandlerException {

		Person p = new Person();
		p.setId(5L);p.setName("p1");
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		Person r = restApiRequestHandler.sendRequest("http://localhost:8090/test9", HttpMethod.POST, requestHeaders, p, Person.class);
		System.out.println(r);
	}

	public void test12() throws RestApiRequestHandlerException {

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		Void r = restApiRequestHandler.sendRequest("http://localhost:8090/test11", HttpMethod.GET, requestHeaders, Void.class);
		System.out.println(r);
	}
}


@Getter
@Setter
@ToString
class Person {
	private Long id;
	private String name;

}