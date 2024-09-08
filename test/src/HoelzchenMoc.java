import hoelzchen.Hoelzchen;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Testclass for Hoelzchen game
 */
public class HoelzchenMoc extends Hoelzchen {

    private static Stream<Arguments> inputRemainders() {
        return Stream.of(
                arguments(0, 21,false),
                arguments(1, 21,true),
                arguments(2, 21,true),
                arguments(3, 21,true),
                arguments(3, 3,true),
                arguments(3, 2,false),
                arguments(3, 1,false)
        );
    }

    @ParameterizedTest
    @MethodSource("inputRemainders")
    public void testValidateInput(int inp,int remain,boolean result){
        var res=validateIntput(inp,remain);
        assertTrue(res==result,"invalid input");
    }
}
