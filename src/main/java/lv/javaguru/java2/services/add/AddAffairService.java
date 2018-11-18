package lv.javaguru.java2.services.add;

import lv.javaguru.java2.db.AffairRepository;
import lv.javaguru.java2.domain.Affair;
import lv.javaguru.java2.services.Error;
import lv.javaguru.java2.services.add.validation.AddAffairValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddAffairService {

    @Autowired
    private AffairRepository repository;

    @Autowired
    private AddAffairValidator validator;

    public AddAffairResponse addAffair(AddAffairRequest request) {
        List<Error> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddAffairResponse(errors);
        }
        Affair affair = new Affair();
        affair.setTitle(request.getTitle());
        affair.setDescription(request.getDescription());
//        affair.setAffairDeadline(deadline);
//        affair.setAffairStatus(status);

        repository.save(affair);
        return new AddAffairResponse(affair.getId());
    }
}
