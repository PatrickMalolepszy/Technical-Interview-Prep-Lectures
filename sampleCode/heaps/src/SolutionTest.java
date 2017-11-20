import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {
    @Test
    public void testSol() {
        List<String> messages = Arrays.asList("pat", "hi", "test", "test" ,"pat", "there");
        List<Integer> counts = Solution.kFrequentWords(messages, 2);
        System.out.println(counts);
    }
}
