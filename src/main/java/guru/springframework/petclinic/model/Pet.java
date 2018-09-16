package guru.springframework.petclinic.model;

import java.time.LocalDate;

public class Pet {

    private PetType petyType;
    private Owner owner;
    private LocalDate birthDate;


    public PetType getPetyType() {
        return petyType;
    }

    public void setPetyType(PetType petyType) {
        this.petyType = petyType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
