package com.tu.ribbon;

import com.tu.common.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuyongjian on 2018/8/9.
 */

@RestController
public class RibbonConsumerController {

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String helloController(){
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }


    /**
     * getForEntity 请求会返回请求的状态码以及实体
     * getForObject 只会返回请求的实体
     * @return
     */
    @RequestMapping("/gethello")
    public String getHello() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class);
        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity .getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>")
                .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
                .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
                .append("responseEntity.getHeaders()：").append(headers).append("<hr>");
        return result.toString();
    }


    @RequestMapping("/sayhello")
    public String sayHello() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/sayhello?name={1}", String.class, "张三");
        return responseEntity.getBody();
    }
    @RequestMapping("/sayhello2")
    public String sayHello2() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "李四");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/sayhello?name={name}", String.class, map);
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/getbook1", method = RequestMethod.GET)
    public Book book1() {
        return new Book("三国演义", 90, "罗贯中", "花城出版社");
    }

    /**
     *postForEntity 是post请求方法，也会返回请求的状态码以及实体
     * postForObject 是只会返回实体
     * @return
     */
    @RequestMapping(value = "/book3")
    public Book book3() {
        Book book = new Book();
        book.setName("红楼梦");
        ResponseEntity<Book> responseEntity = restTemplate.postForEntity("http://HELLO-SERVICE/getbook2", book, Book.class);
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/book4")
    public Book book4() {
        Book book1 = new Book();
        book1.setName("红楼梦---test");
        Book book = restTemplate.postForObject("http://HELLO-SERVICE/getbook2", book1, Book.class);
        return book;
    }

}
