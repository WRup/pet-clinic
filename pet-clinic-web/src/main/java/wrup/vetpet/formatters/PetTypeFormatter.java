package wrup.vetpet.formatters;

import wrup.vetpet.model.PetType;
import wrup.vetpet.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        return petTypeService.findAll().stream()
                .filter(p -> p.getName().equals(text))
                .findFirst()
                .orElseThrow(() -> new ParseException("type not found: " + text, 0));
    }
}
