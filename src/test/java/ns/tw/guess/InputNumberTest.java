package ns.tw.guess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by lixueying on 15/11/22.
 */
public class InputNumberTest {

    @Test
    public void should_return_false_when_input_abcd(){
        String guessed = "abcd";
        boolean flag = InputNumber.is_duplicate_numbers(guessed);
        assertThat(flag,is(false));
    }

    @Test
    public void should_return_false_when_input_1123(){
        String guessed = "1123";
        boolean flag = InputNumber.is_duplicate_numbers(guessed);
        assertThat(flag,is(false));
    }
}
