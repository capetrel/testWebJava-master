package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by capetrel on 03/06/2016.
 */

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Yo!";
    }

}