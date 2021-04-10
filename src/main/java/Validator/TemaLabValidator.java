package Validator;

import Domain.TemaLab;
import Exceptions.ValidatorException;

public class TemaLabValidator implements IValidator<TemaLab> {

    public void validate(TemaLab t) throws ValidatorException {
        if (t.getId() == null) {
            throw new ValidatorException("Nr tema invalid\n");
        }
        if (t.getDescriere() == null || t.getDescriere().equals("")) {
            throw new ValidatorException("Descriere tema invalida\n");
        }
        if (t.getSaptamanaPredarii() <= 0 || t.getSaptamanaPredarii() > 14) {
            throw new ValidatorException("Sapatamana predarii invalida\n");
        }
        if (t.getTermenLimita() <= 0 || t.getTermenLimita() > 14) {
            throw new ValidatorException("Termen limita invalid\n");
        }
    }
}
