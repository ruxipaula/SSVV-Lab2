package Service.TxtFileService;

import Domain.Student;
import Repository.TxtFileRepository.StudentFileRepo;

public class StudentService extends AbstractService<String,Student> {
    //StudentFileRepo stdRepo;
    public StudentService(StudentFileRepo stdRepo){
        super(stdRepo);
    }
    /*
    @Override
    public Student extractEntity(String[] info){
        return new Student("","",2,"","");
    }
    */
}


