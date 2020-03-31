package tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.Ingredient;
import tacos.Taco;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("0", "0", Ingredient.Type.WRAP),
                new Ingredient("1", "1", Ingredient.Type.WRAP),
                new Ingredient("2", "2", Ingredient.Type.PROTEIN),
                new Ingredient("3", "3", Ingredient.Type.PROTEIN),
                new Ingredient("4", "4", Ingredient.Type.VEGGIES),
                new Ingredient("5", "5", Ingredient.Type.VEGGIES),
                new Ingredient("6", "6", Ingredient.Type.CHEESE),
                new Ingredient("7", "7", Ingredient.Type.CHEESE),
                new Ingredient("8", "8", Ingredient.Type.SAUCE),
                new Ingredient("9", "9", Ingredient.Type.SAUCE)
        );
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(Taco design) {
        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }
}
