package seedu.duke.command;
import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.ExceptionMain;
import seedu.duke.exceptions.secrets.InvalidURLException;
import seedu.duke.exceptions.secrets.SecretNotFoundException;
import seedu.duke.secrets.BasicPassword;
import seedu.duke.secrets.NUSNet;
import seedu.duke.secrets.StudentID;
import seedu.duke.storage.SecretMaster;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author : Steven A. O. Waskito
 **/
public class AddCommandTest {
    @Test
    public void studentIDTestFolder() throws SecretNotFoundException, ExceptionMain {
        SecretMaster sm = new SecretMaster();
        StudentID studentID = new StudentID("StudentID2Name", "StudentsOfNUS", "A021313G");
        Command addStudentId = new AddStudentIDCommand(studentID);
        addStudentId.execute(sm);
        assertEquals("StudentID2Name",sm.getByName("StudentID2Name").getName());
    }
    @Test
    public void nusNetFolder() throws SecretNotFoundException, ExceptionMain {
        SecretMaster sm = new SecretMaster();
        NUSNet nusNet = new NUSNet("NUSNetName2", "FolderName", "e081888@u.nus.edu", "Lorem Ipsum 12");
        Command addNusNet = new AddNUSNetCommand(nusNet);
        addNusNet.execute(sm);
        assertEquals("NUSNetName2", sm.getByName("NUSNetName2").getName());
    }
    @Test
    void basicPasswordFolder() throws InvalidURLException, SecretNotFoundException, ExceptionMain {
        SecretMaster sm = new SecretMaster();
        BasicPassword basicPassword =
                new BasicPassword("basicPassword1", "FolderName", "basicUsername", "Lorem Ipsum 112", "google.com");
        Command addBasicPassword = new AddBasicPasswordCommand(basicPassword);
        addBasicPassword.execute(sm);
        assertEquals("basicPassword1", sm.getByName("basicPassword1").getName());
    }
}
