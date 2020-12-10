package assigment6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

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

            
            assertEquals("[Josh, Rick]", a.toString());
        }

        @Test
        void separationBySpaceTestSuccessOneElement() {

            injector = new SeparateNamesBySpace();

            List<String> a = injector.separateNames("Robert   Joseph");
            
            assertEquals("Joseph", a.get(1));
        }

        @Test
        void separationBySpaceTestSuccessWholeArray() {

            injector = new SeparateNamesBySpace();

            List<String> a = injector.separateNames("Robert   Joseph");
            
            assertEquals("Joseph", a.get(1));
        }   

        


}
