import Domain.Nota;
import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.NotaXMLRepo;
import Repository.XMLFileRepository.StudentXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.NotaXMLService;
import Service.XMLFileService.StudentXMLService;
import Service.XMLFileService.TemaLabXMLService;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemaLabValidator;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

public class GradeTest {
    NotaValidator vn;
    NotaXMLRepo nrepo;
    NotaXMLService nsrv;

    StudentValidator vs;
    StudentXMLRepo strepo;
    StudentXMLService stsrv;

    TemaLabValidator vt;
    TemaLabXMLRepo tlrepo;
    TemaLabXMLService tlsrv;

    public GradeTest() {
        vn = new NotaValidator();
        nrepo = new NotaXMLRepo(vn, "NotaiXML.xml");
        nsrv = new NotaXMLService(nrepo);

        vs = new StudentValidator();
        strepo = new StudentXMLRepo(vs, "StudentiXML.xml");
        stsrv = new StudentXMLService(strepo);

        vt = new TemaLabValidator();
        tlrepo = new TemaLabXMLRepo(vt, "TemaLabiXML.xml");
        tlsrv = new TemaLabXMLService(tlrepo);
    }

    @Test
    public void tc_1_addStudent_valid() {
        String[] params = {"1", "Student 1", "936", "student1@mail.com", "Prof 1"};
        try {
            stsrv.add(params);
            Assert.assertEquals(stsrv.getSize(), 1);
        } catch (ValidatorException e) {
            Assert.fail();
        }
    }

    @Test
    public void tc_2_addAssignment_valid() {
        TemaLab assigment = new TemaLab(1, "Tema 1", 12, 13);
        try {
            tlrepo.save(assigment);
            Assert.assertEquals(tlsrv.getSize(), 1);
        } catch (ValidatorException e) {
            Assert.fail();
        }
    }

    @Test
    public void tc_3_addGrade_valid() {
        Nota grade = new Nota(1, "1", 1, 9, LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40));
        try {
            nrepo.save(grade);
            Assert.assertEquals(nsrv.getSize(), 1);
        } catch (ValidatorException e) {
            Assert.fail();
        }
    }

    @Test
    public void tc_4_addGrade_BBI() {
        tc_1_addStudent_valid();
        tc_2_addAssignment_valid();
        tc_3_addGrade_valid();
    }
}
