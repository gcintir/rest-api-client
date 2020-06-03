package restapiclient.restapiclient;


import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@Log4j2
public class Controller {

    @RequestMapping(value = "/test1", method = RequestMethod.GET,  consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> test1() {

        return ResponseEntity.ok("test1 completed");

    }

    @RequestMapping(value = "/test2/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> test2(@PathVariable("id") Long id) {

        return ResponseEntity.ok("test2 completed with id " + id);

    }

    @RequestMapping(value = "/test3", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> test3(@RequestParam(name = "id") String id) {

        return ResponseEntity.ok("test3 completed with id " + id);

    }

    @RequestMapping(value = "/test4", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> test4(@RequestParam(name = "id") String id, @RequestParam(name = "name") String name) {

        return ResponseEntity.ok("test4 completed with id " + id + " name " + name);

    }

    @RequestMapping(value = "/test5", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> test5(@RequestParam(name = "id") String id, @RequestParam(name = "name") String name) {

        return ResponseEntity.ok("test5 completed with id " + id + " name " + name);

    }

    @RequestMapping(value = "/test6", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> test6(@RequestBody Person person) {

        return ResponseEntity.ok("test6 completed with person " + person);

    }

    @RequestMapping(value = "/test7", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> test7(@RequestBody Person person, @RequestParam(name = "id") String id) {

        return ResponseEntity.ok("test7 completed with person " + person + " and id: " + id);

    }

    @RequestMapping(value = "/test8", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> test8(HttpServletRequest request) {

        StringBuilder sb = new StringBuilder();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            sb.append(key).append(":").append(value).append(System.lineSeparator());
        }

        return ResponseEntity.ok("test8 completed with data " + sb.toString());

    }

    @RequestMapping(value = "/test9", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> test9(@RequestBody Person person) {

        return ResponseEntity.ok(person);

    }

    @RequestMapping(value = "/test10", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Person>> test10() {

        Map<String, Person> data = new HashMap<>();
        Person p = new Person();
        p.setId(3L);
        p.setName("pppp");
        data.put("1", p);

        return ResponseEntity.ok(data);

    }



}

