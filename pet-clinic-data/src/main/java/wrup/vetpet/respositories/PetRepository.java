package wrup.vetpet.respositories;

import wrup.vetpet.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
