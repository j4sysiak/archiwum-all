import com.company.modulelevel.model.Circle;
import com.company.modulelevel.model.Point;
import com.company.modulelevel.model.ShapeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class test {

    private List<String> library;
    private Circle circle;

    @BeforeEach
    public void setUp() {
        library = new ArrayList(Arrays.asList("aaa", "bbb", "ccc"));
        circle = Circle.create(ShapeType.Circle, 22, Point.create(22, 22));
    }

    @Test
    public void test1() {
        assertTrue(library.size() > 0);
    }

    @Test
    public void test2() {
        assertEquals(22, circle.getRadius());
    }

    @Test
    public void test3() {
        assertThat(circle.getRadius()==22);
    }
}

