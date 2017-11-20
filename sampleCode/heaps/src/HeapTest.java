import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeapTest {

    private Heap<Integer> heap;

    @Before
    public void init() {
        heap = new Heap<>();
        heap.push(3);
        heap.push(2);
        heap.push(5);
        heap.push(4);
    }

    @Test
    public void TopOfHeapShouldBeMaxElement() {
        // Arrange
        int  expected = 5;
        // Act
        int result = heap.top();
        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void PoppingElementShouldRemoveMax() {
        // Arrange
        int expected = 4; // 2nd largest
        // Act
        heap.pop();
        int result = heap.top();
        // Assert
        Assert.assertEquals(expected, result);
    }
}
