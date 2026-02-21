import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProgramControlTest {
    @Mock
    Program program;

    @Mock
    String dataFolder;

    @Test
    void noArguments() { // how to take args
        TopSecret topSecret0 = new TopSecret0(dataFolder);

    }

    @Test
    void nonIntArguments() {
        TopSecret topSecret1 = new TopSecret1(dataFolder);
        topSecret1.programControl("Alakazam", dataFolder);
    }

    @Test
    void tooManyArguments() {
        TopSecret topSecret2 = new TopSecret2(dataFolder);
        topSecret2.programControl("Squirtle", "Charizard", "Heracross", "Escavalier", dataFolder);
    }

    @Test
    void argumentNotInRangeNegative(){
        TopSecret topSecret3 = new TopSecret3(dataFolder);
        topSecret3.programControl(-10, dataFolder);
    }

    @Test
    void argumentNotInRangePositive(){
        TopSecret topSecret4 = new TopSecret4(dataFolder);
        topSecret4.programControl(1000, dataFolder);
    }

    @Test
    void fileMissing(){
        TopSecret topSecret5 = new TopSecret5();
        topSecret5.programControl(3);
    }

}