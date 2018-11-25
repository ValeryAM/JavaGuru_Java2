package lv.javaguru.java2.services.remove;

import lv.javaguru.java2.db.AffairRepository;
import lv.javaguru.java2.domain.Affair;
import lv.javaguru.java2.services.Error;
import lv.javaguru.java2.services.remove.validation.RemoveAffairValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RemoveAffairService {

    @Autowired
    private AffairRepository repository;

    @Autowired
    private RemoveAffairValidator validator;

    public RemoveAffairResponse removeAffair(RemoveAffairRequest request) {
        List<Error> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveAffairResponse(errors);
        }

        Optional<Affair> foundAffair = repository.findAffairByTitle(request.getTitle());
        Affair affair = foundAffair.get();
        repository.removeAffair(affair);
        return new RemoveAffairResponse(affair.getId());

/*    public boolean remove(String title) {
        Optional<Affair> foundAffair = database.findAffairByTitle(title);
        if (foundAffair.isPresent()) {
            Affair affair = foundAffair.get();
            return database.removeAffair(affair);
        } else {
            return false;
        }
    }
*/
    }
}
