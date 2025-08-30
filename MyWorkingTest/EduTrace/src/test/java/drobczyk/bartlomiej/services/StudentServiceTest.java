package drobczyk.bartlomiej.services;

import drobczyk.bartlomiej.exceptions.ArchivedPositionBeyondBoundriesException;
import drobczyk.bartlomiej.exceptions.NoSuchLessonToDelete;
import drobczyk.bartlomiej.exceptions.NoSuchLessonToEdit;
import drobczyk.bartlomiej.model.dto.LessonDto;
import drobczyk.bartlomiej.model.dto.addition_form.LessonFormInfo;
import drobczyk.bartlomiej.model.lesson.Lesson;
import drobczyk.bartlomiej.model.student.Student;
import drobczyk.bartlomiej.model.subject.Subject;
import drobczyk.bartlomiej.repo.LessonRepo;
import drobczyk.bartlomiej.repo.StudentRepo;
import drobczyk.bartlomiej.session.TeacherSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    private Student testStudent;
    private Set<Lesson> testLessons;
    private StudentService underTest;
    @Mock
    private StudentRepo studentRepo;
    @Mock
    private LessonRepo lessonRepo;
    @Mock
    private SubjectService subjectService;
    @Mock
    private DayService dayService;
    @Mock
    private TeacherSession teacherSession;
    private final Random random = new Random();

    @BeforeEach
    void setUp() {
        testStudent = new Student();
        testLessons = Stream.generate(() -> new Lesson(new Subject("Fizyka"), "Arytmetyka", "Podręcznik",
                "Comment", getRandomDate(), testStudent))
                .limit(50)
                .collect(Collectors.toSet());
        testLessons.forEach(x -> x.setId(getNextLong()));
        testStudent.setLessons(testLessons);
        testStudent.setLastArchivedPosition(0L);
        testStudent.setId(7L);
        underTest = new StudentService(studentRepo, lessonRepo, subjectService, dayService, teacherSession);
        lenient().when(studentRepo.findById(testStudent.getId()))
                .thenReturn(Optional.of(testStudent));
    }

    private Long getNextLong() {
        int nonNullSize = testLessons.stream()
                .filter(x -> x.getId() != null)
                .collect(Collectors.toSet())
                .size();
        return (long) nonNullSize;
    }

    private LocalDateTime getRandomDate() {
        return LocalDateTime.now()
                .plusDays(random.longs(1L, 10L)
                        .findFirst()
                        .orElseThrow(() -> new DateTimeException("Błąd zakresu")));
    }

    @ParameterizedTest
    @ValueSource(longs = {0, 5, 10, 15, 20, 25, 30, 35, 45, 49})
    public void shouldProvideOrderedLessonSublist(Long index) {
        //given
        testStudent.setLastArchivedPosition(index);
        //when
        List<LessonDto> testSubList = underTest.getCurrentLessonsDto(testStudent.getId());
        //then
        assertThat(testSubList.size()).isEqualTo(testStudent.getLessons().size() - testStudent.getLastArchivedPosition());
    }

    @ParameterizedTest
    @ValueSource(longs = {0, 5, 10, 15, 20, 25, 30, 35, 45, 49})
    public void shouldSetArchivedIndexEqualListSize(Long index) {
        //given
        testStudent.setLastArchivedPosition(index);
        Long listSizeAndArchivedPositionDifference = testStudent.getLessons().size() - testStudent.getLastArchivedPosition();
        //when
        underTest.archiveCurrentLessons(testStudent.getId(), listSizeAndArchivedPositionDifference);

        //then
        var capturedStudent = ArgumentCaptor.forClass(Student.class);
        verify(studentRepo).save(capturedStudent.capture());
        assertThat(capturedStudent.getValue().getLastArchivedPosition()).isEqualTo(50L);
    }

    @ParameterizedTest
    @ValueSource(longs = {0, 5, 10, 15, 20, 25, 30, 35, 45, 49})
    public void shouldRemoveLessonFromStudent(Long index) {
        //when
        underTest.deleteStudentsLesson(testStudent.getId(), index);
        //then
        assertThat(testStudent.getLessons().size()).isEqualTo(50 - 1);
    }

    @ParameterizedTest
    @ValueSource(longs = {-345, -734, 568, 777})
    public void shouldThrowNoSuchLessonException(Long wrongIndex) {
        //when
        assertThatThrownBy(() -> underTest.deleteStudentsLesson(testStudent.getId(), wrongIndex))
                .isInstanceOf(NoSuchLessonToDelete.class)
                .hasMessageContaining("Brak takiej lekcji do usnięcia");
        //then
        verify(mock(StudentService.class), never()).saveStudent(any());
    }

    @ParameterizedTest
    @ValueSource(longs = {-345, -734, 568, 777})
    public void shouldThrowNoSuchLessonToEdit(Long wrongLessonId) {
        //given
        LessonFormInfo editForm = new LessonFormInfo();
        //when
        assertThatThrownBy(() -> underTest.editStudentLesson(testStudent, editForm, wrongLessonId))
                .isInstanceOf(NoSuchLessonToEdit.class)
                .hasMessageContaining("Brak takiej lekcji do edycji");
    }

    @ParameterizedTest
    @ValueSource(longs = {-345, -734, 568, 777})
    public void shouldThrowArchivedPositionBeyondBoundriesException(Long wrongIndex) {
        //given
        testStudent.setLastArchivedPosition(wrongIndex);
        //when
        assertThatThrownBy(() -> underTest.getCurrentLessonsDto(testStudent.getId()))
                .isInstanceOf(ArchivedPositionBeyondBoundriesException.class)
                .hasMessageContaining("Zarchiwizona pozycja lekcji jest spoza zakresu zapisanych lekcji");
    }


    @Test
    public void shouldSaveEditedLesson() {
        //given
        LessonFormInfo editedInfo = new LessonFormInfo();
        editedInfo.setChosenLesson("Matematyka");
        editedInfo.setLessonSection("Ułamki");
        editedInfo.setHomework("Podręcznik strona 45");
        editedInfo.setLessonComment("Powtórzyć sprowadzanie do wspólnego mianownika");
        editedInfo.setStudentId(testStudent.getId());

        //when
        given(subjectService.findSubjectByDesc("Matematyka"))
                .willReturn(new Subject("Matematyka"));
        underTest.editStudentLesson(testStudent, editedInfo, 1L);
        var capturedEditedLesson = ArgumentCaptor.forClass(Lesson.class);
        verify(lessonRepo).save(capturedEditedLesson.capture());
        Lesson editedLesson = capturedEditedLesson.getValue();
        assertThat(editedLesson.getSubject().getSubject()).isEqualTo(editedInfo.getChosenLesson());
        assertThat(editedLesson.getLessonTopic()).isEqualTo(editedInfo.getLessonSection());
        assertThat(editedLesson.getHomework()).isEqualTo(editedInfo.getHomework());
        assertThat(editedLesson.getLessonComment()).isEqualTo(editedInfo.getLessonComment());
    }
}