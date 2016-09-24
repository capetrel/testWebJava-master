/**
 * Created by capetrel on 02/06/2016.
 */
package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
            model.addAttribute("name", name);
            return "greeting";
    }

    /**
     * On peu indiquer plusieurs url pour une même méthode
     * return string nom du template
     * @return
     */
    @RequestMapping(path={"/","index"})
    public String index() {
        return "index";
    }

    @RequestMapping(path={"/","about"})
    public String about() {
        return "about";
    }

    @RequestMapping(path={"/","project-01"})
    public String projectUn() {
        return "project-01";
    }

    @RequestMapping(value="/about1", method=RequestMethod.GET)
    public String aboutForm(Model model) {
        model.addAttribute("about", new FormTestAbout());
        return "about";
    }

    @RequestMapping(value="/about", method=RequestMethod.POST)
    public String aboutSubmit(@ModelAttribute FormTestAbout about, Model model) {
        model.addAttribute("about", about);
        return "about-result";
    }

    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new FormTest());
        return "greeting";
    }

    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute FormTest greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }


}