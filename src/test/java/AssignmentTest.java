import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.TemaLabXMLService;
import Validator.TemaLabValidator;
import org.junit.Assert;
import org.junit.Test;

public class AssignmentTest {
    TemaLabValidator vs;
    TemaLabXMLRepo asrepo;
    TemaLabXMLService asarv;

    public AssignmentTest() {
        vs = new TemaLabValidator();
        asrepo = new TemaLabXMLRepo(vs, "TemaLabiXML.xml");
        asarv = new TemaLabXMLService(asrepo);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tc_1_addAssignment_nullValue() throws ValidatorException {
        asrepo.save(null);
        Assert.assertEquals(asarv.getSize(), 1);
    }

    @Test(expected = ValidatorException.class)
    public void tc_2_addAssignment_idInvalid() throws ValidatorException {
        TemaLab assigment = new TemaLab(null, "Tema 1", 10, 11);
        asrepo.save(assigment);
    }

    @Test(expected = ValidatorException.class)
    public void tc_3_addAssignment_descriereInvalid() throws ValidatorException {
        TemaLab assigment = new TemaLab(1, "", 10, 11);
        asrepo.save(assigment);
    }

    @Test(expected = ValidatorException.class)
    public void tc_4_addAssignment_termenLimitaInvalid() throws ValidatorException {
        TemaLab assigment = new TemaLab(1, "Tema 1", 17, 11);
        asrepo.save(assigment);
    }

    @Test(expected = ValidatorException.class)
    public void tc_5_addAssignment_saptamanaPredariiInvalid() throws ValidatorException {
        TemaLab assigment = new TemaLab(1, "Tema 1", 12, -7);
        asrepo.save(assigment);
    }

    @Test
    public void tc_6_addAssignment_valid() {
        TemaLab assigment = new TemaLab(1, "Tema 1", 12, 13);
        try {
            asrepo.save(assigment);
            Assert.assertEquals(asarv.getSize(), 1);
        } catch (ValidatorException e) {
            Assert.fail();
        }
    }

}
