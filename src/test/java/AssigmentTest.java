import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.TemaLabXMLService;
import Validator.TemaLabValidator;
import org.junit.Assert;
import org.junit.Test;

public class AssigmentTest {
    TemaLabValidator vs;
    TemaLabXMLRepo asrepo;
    TemaLabXMLService asarv;

    public AssigmentTest() {
        vs = new TemaLabValidator();
        asrepo = new TemaLabXMLRepo(vs, "TemaLabiXML.xml");
        asarv = new TemaLabXMLService(asrepo);
    }

    @Test
    public void tc_1_addAssigment_idValid() {
        TemaLab assigment = new TemaLab(1, "Tema 1", 11, 10);
        try {
            asrepo.save(assigment);
            Assert.assertEquals(asarv.getSize(), 1);
        } catch (ValidatorException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(expected = ValidatorException.class)
    public void tc_2_addAssigment_idInvalid() throws ValidatorException {
        TemaLab assigment = new TemaLab(null, "Tema 1", 11, 10);
        asrepo.save(assigment);
    }

}
