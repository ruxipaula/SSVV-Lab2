import Exceptions.ValidatorException;
import Repository.XMLFileRepository.StudentXMLRepo;
import Service.XMLFileService.StudentXMLService;
import Validator.StudentValidator;
import org.junit.Assert;
import org.junit.Test;

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
    public void tc_1_addStudent_groupValidInteger() {
        String[] params = {"1", "Student 1", "936", "student1@mail.com", "Prof 1"};
        try {
            stsrv.add(params);
            Assert.assertEquals(stsrv.getSize(), 1);
        } catch (ValidatorException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(expected = ValidatorException.class)
    public void tc_2_addStudent_groupInvalidInteger() throws ValidatorException {
        String[] params = {"1", "Student 1", "abc", "student1@mail.com", "Prof 1"};
        stsrv.add(params);
    }

    @Test
    public void tc_3_addStudent_groupValidRange() {
        String[] params = {"1", "Student 1", "911", "student1@mail.com", "Prof 1"};
        try {
            stsrv.add(params);
            Assert.assertEquals(stsrv.getSize(), 1);
        } catch (ValidatorException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(expected = ValidatorException.class)
    public void tc_4_addStudent_groupInvalidRange() throws ValidatorException {
        String[] params = {"1", "Student 1", "-4", "student1@mail.com", "Prof 1"};
        stsrv.add(params);
    }

    @Test
    public void tc_5_addStudent_idValid() {
        String[] params = {"1", "Student 1", "911", "student1@mail.com", "Prof 1"};
        try {
            stsrv.add(params);
            Assert.assertEquals(stsrv.getSize(), 1);
        } catch (ValidatorException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(expected = ValidatorException.class)
    public void tc_6_addStudent_idInvalid() throws ValidatorException {
        String[] params = {"", "Student 1", "911", "student1@mail.com", "Prof 1"};
        stsrv.add(params);
    }

    @Test
    public void tc_7_addStudent_nameValid() {
        String[] params = {"1", "James", "911", "student1@mail.com", "Prof 1"};
        try {
            stsrv.add(params);
            Assert.assertEquals(stsrv.getSize(), 1);
        } catch (ValidatorException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(expected = ValidatorException.class)
    public void tc_8_addStudent_nameInvalid() throws ValidatorException {
        String[] params = {"1", "", "911", "student1@mail.com", "Prof 1"};
        stsrv.add(params);
    }

    @Test
    public void tc_9_addStudent_emailValid() {
        String[] params = {"1", "Student 1", "911", "adipopa9910@gmail.com", "Prof 1"};
        try {
            stsrv.add(params);
            Assert.assertEquals(stsrv.getSize(), 1);
        } catch (ValidatorException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(expected = ValidatorException.class)
    public void tc_10_addStudent_emailInvalid() throws ValidatorException {
        String[] params = {"1", "Student 1", "911", "", "Prof 1"};
        stsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_11_addStudent_groupInvalid_BVA1() throws ValidatorException {
        String[] params = {"1", "Student 1", "0", "student1@mail.com", "Prof 1"};
        stsrv.add(params);
    }

    @Test
    public void tc_12_addStudent_groupValid_BVA2() {
        String[] params = {"1", "Student 1", "1", "student1@mail.com", "Prof 1"};
        try {
            stsrv.add(params);
            Assert.assertEquals(stsrv.getSize(), 1);
        } catch (ValidatorException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void tc_13_addStudent_groupValid_BVA3() {
        String[] params = {"1", "Student 1", "2", "student1@mail.com", "Prof 1"};
        try {
            stsrv.add(params);
            Assert.assertEquals(stsrv.getSize(), 1);
        } catch (ValidatorException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void tc_14_addStudent_groupValid_BVA4() {
        String[] params = {"1", "Student 1", "2147483646", "student1@mail.com", "Prof 1"};
        try {
            stsrv.add(params);
            Assert.assertEquals(stsrv.getSize(), 1);
        } catch (ValidatorException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void tc_15_addStudent_groupValid_BVA5() {
        String[] params = {"1", "Student 1", "2147483647", "student1@mail.com", "Prof 1"};
        try {
            stsrv.add(params);
            Assert.assertEquals(stsrv.getSize(), 1);
        } catch (ValidatorException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(expected = ValidatorException.class)
    public void tc_16_addStudent_groupInvalid_BVA6() throws ValidatorException {
        String[] params = {"1", "Student 1", "2147483648", "student1@mail.com", "Prof 1"};
        stsrv.add(params);
    }
}
