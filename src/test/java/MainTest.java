import Exceptions.ValidatorException;
import Repository.XMLFileRepository.StudentXMLRepo;
import Service.XMLFileService.StudentXMLService;
import Validator.StudentValidator;

import org.junit.*;

public class MainTest {

    StudentValidator vs;
    StudentXMLRepo strepo;
    StudentXMLService stsrv;

    public MainTest() {
        vs = new StudentValidator();
        strepo = new StudentXMLRepo(vs, "StudentiXML.xml");
        stsrv = new StudentXMLService(strepo);
    }

    @Test
    public void tc_1_AddStudentSuccess() {
        String[] params={"1","Student 1","333","student1@mail.com","Prof 1"};
        try {
            stsrv.add(params);

            Assert.assertEquals(stsrv.getSize(), 1);
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void tc_1_AddStudentFailed() {
        String[] params={"1","Student 1","abc","student1@mail.com","Prof 1"};
        try {
            stsrv.add(params);

            Assert.assertEquals(stsrv.getSize(), 0);
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
    }
}
