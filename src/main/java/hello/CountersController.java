package hello;

import hello.models.CounterModel;
import hello.services.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Montre l'utilisation de propriétés (variables d'objets) automatiquement affectées par Spring (@Autowired).
 * Durée de vie des instances (life scope @Scope):
 * - counterService: la durée de vie est indiquée dans la classe CounterService.
 * - counterApp & counterSession: durée de vie indiquée à l'instanciation dans la class Application (étape @Configuration).
 */
@Controller
public class CountersController {

    @Autowired
    @Qualifier("appCounter")
    CounterModel counterApp ;

    @Autowired
    CounterService counterService ;

    @RequestMapping( "/counter1" )
    public String counterWithService(
            @RequestParam(value = "inc", required = false, defaultValue = "1") long inc,
            Model model )
    {
        model.addAttribute("count", this.counterService.inc( inc ));
        model.addAttribute("appCount", this.counterApp.inc( inc ));
        return "counter";
    }

    @Autowired
    @Qualifier("sessionCounter")
    CounterModel counterSession ;

    @RequestMapping( "/counter2" )
    public String counterWithModel(
            @RequestParam(value = "inc", required = false, defaultValue = "1") long inc,
            Model model
    )
    {
        model.addAttribute("count", this.counterSession.inc( inc ));
        model.addAttribute("appCount", this.counterApp.inc( inc ));
        return "counter";
    }

}