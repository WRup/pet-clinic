package wrup.vetpet.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import wrup.vetpet.model.*;
import wrup.vetpet.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentristry = specialtyService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Mildred");
        owner1.setLastName("Ouellette");
        owner1.setAddress("3141 Palmer Road");
        owner1.setCity("Westerville");
        owner1.setTelephone("202-555-0112");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Jambor");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Karin");
        owner2.setLastName("Smith");
        owner2.setAddress("1806 Davis Court");
        owner2.setCity("Stlouis");
        owner2.setTelephone("202-555-0187");

        Pet fionasCat = new Pet();
        fionasCat.setName("Gibsy");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(saveCatPetType);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Daniel");
        owner3.setLastName("Bunch");
        owner3.setAddress("3379 Woodland Drive");
        owner3.setCity("Sioux City");
        owner3.setTelephone("501-555-0154");

        Pet pet3 = new Pet();
        pet3.setName("Herfa");
        pet3.setOwner(owner3);
        pet3.setBirthDate(LocalDate.now());
        pet3.setPetType(saveCatPetType);
        owner3.getPets().add(pet3);

        ownerService.save(owner3);

        Owner owner4 = new Owner();
        owner4.setFirstName("Patricia");
        owner4.setLastName("Jelks");
        owner4.setAddress("2965 Thrash Trail");
        owner4.setCity("Point");
        owner4.setTelephone("501-555-0184");

        Pet pet4 = new Pet();
        pet4.setName("Gibsy");
        pet4.setOwner(owner4);
        pet4.setBirthDate(LocalDate.now());
        pet4.setPetType(saveDogPetType);
        owner4.getPets().add(pet4);

        Pet pet41 = new Pet();
        pet41.setName("Hiony");
        pet41.setOwner(owner4);
        pet41.setBirthDate(LocalDate.now());
        pet41.setPetType(saveDogPetType);
        owner4.getPets().add(pet41);

        ownerService.save(owner4);

        Owner owner5 = new Owner();
        owner5.setFirstName("Gail");
        owner5.setLastName("Green");
        owner5.setAddress("4840 Abia Martin Drive");
        owner5.setCity("New York");
        owner5.setTelephone("516-555-0180");

        Pet pet5 = new Pet();
        pet5.setName("Gallus");
        pet5.setOwner(owner5);
        pet5.setBirthDate(LocalDate.now());
        pet5.setPetType(saveDogPetType);
        owner5.getPets().add(pet5);

        ownerService.save(owner5);

        Owner owner6 = new Owner();
        owner6.setFirstName("Andrew");
        owner6.setLastName("Guzman");
        owner6.setAddress("1869 Lost Creek Road");
        owner6.setCity("Fort Washington");
        owner6.setTelephone("516-555-0110");

        Pet pet6 = new Pet();
        pet6.setName("Kaiko");
        pet6.setOwner(owner6);
        pet6.setBirthDate(LocalDate.now());
        pet6.setPetType(saveCatPetType);
        owner6.getPets().add(pet6);

        ownerService.save(owner6);

        Visit visit = new Visit();
        visit.setPet(fionasCat);
        visit.setDate(LocalDate.now());
        visit.setDescription("Sneezy Kitty");

        visitService.save(visit);

        Visit visit2 = new Visit();
        visit2.setPet(pet3);
        visit2.setDate(LocalDate.now());
        visit2.setDescription("Vomiting/Upset Stomach");

        visitService.save(visit2);

        Visit visit3 = new Visit();
        visit3.setPet(pet5);
        visit3.setDate(LocalDate.now());
        visit3.setDescription("Skin Infection");

        visitService.save(visit3);

        Visit visit4 = new Visit();
        visit4.setPet(pet41);
        visit4.setDate(LocalDate.now());
        visit4.setDescription("Periodontitis/Dental Disease");

        visitService.save(visit4);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Charlie");
        vet1.setLastName("Chavez");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Charles");
        vet2.setLastName("Hepner");
        vet2.getSpecialities().add(savedRadiology);

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Dorothy");
        vet3.setLastName("Bates");
        vet3.getSpecialities().add(savedDentristry);

        vetService.save(vet3);

        Vet vet4 = new Vet();
        vet4.setFirstName("Dawn");
        vet4.setLastName("Eldridge");
        vet4.getSpecialities().add(savedDentristry);

        vetService.save(vet4);

        Vet vet5 = new Vet();
        vet5.setFirstName("Donald");
        vet5.setLastName("Schneider");
        vet5.getSpecialities().add(savedSurgery);

        vetService.save(vet5);

        Vet vet6 = new Vet();
        vet6.setFirstName("Richard");
        vet6.setLastName("Byrd");
        vet6.getSpecialities().add(savedSurgery);

        vetService.save(vet6);

        System.out.println("Loaded Vets....");
    }
}
