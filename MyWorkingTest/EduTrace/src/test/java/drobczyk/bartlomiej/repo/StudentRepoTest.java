package drobczyk.bartlomiej.repo;

import drobczyk.bartlomiej.model.student.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StudentRepoTest {

    @Autowired
    private StudentRepo repoTest;

    @Test
    void shouldFindMatchedStudentsByTextSample() {
        //given
        List<Student> testStudent = provideTestStudents();
        testStudent.forEach(repoTest::save);
        //when
        List<Student> twoMatchedStudentsByFirstNameLetter = repoTest.findMatchedStudentsByString("Al");
        List<Student> twoMatchedStudentsByFirstSurnameLetter = repoTest.findMatchedStudentsByString("Ja");
        List<Student> allStudentsByEmptyString = repoTest.findMatchedStudentsByString("");
        Student exactlyOneStudentByName = repoTest.findMatchedStudentsByString("Aleksandra").get(0);
        Student exactlyOneStudentBySurname = repoTest.findMatchedStudentsByString("Jastojewicz").get(0);
        //then
        assertThat(twoMatchedStudentsByFirstNameLetter.size()).isEqualTo(2);
        assertThat(twoMatchedStudentsByFirstSurnameLetter.size()).isEqualTo(2);
        assertThat(allStudentsByEmptyString.size()).isEqualTo(2);
        assertThat(exactlyOneStudentByName).isEqualTo(testStudent.get(0));
        assertThat(exactlyOneStudentBySurname).isEqualTo(testStudent.get(1));
    }

    private List<Student> provideTestStudents() {
        Student aleksandra = new Student();
        aleksandra.setName("Aleksandra");
        aleksandra.setSurname("Jastrzębska");
        Student magda = new Student();
        magda.setName("Magdalena");
        magda.setSurname("Jastojewicz");
        return List.of(aleksandra, magda);
    }

}