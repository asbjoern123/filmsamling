import org.junit.jupiter.api.AfterEach;
import java.io.File;



public class FileHandlerTest {
    private static final String TEST_FILE = "test-movies.csv";

    @AfterEach
    void deleteTestFile() {
        new File(TEST_FILE).delete();
    }


}

