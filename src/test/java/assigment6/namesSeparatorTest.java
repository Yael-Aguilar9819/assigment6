package assigment6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class namesSeparatorTest {

        /**
         * Rigorous Test.
         */
        NamesSeparator injector;
    
        @Test
        void separationByCommaTestSuccessWholeArray() {
            injector = new SeparateNamesByComma();

            List<String> a = injector.separateNames("josh, rick");

            
            assertEquals("[josh, kris]", a.toString());
        }

        


}
