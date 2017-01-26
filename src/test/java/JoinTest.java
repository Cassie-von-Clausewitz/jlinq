import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.function.Predicate;

import collections.Queriable;
import collections.ReferenceQueriable;

public class JoinTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void NullPredicateThrowsNullArgumentException()
    {
        Integer[] numbers = { 1, 3, 7, 9, 10 };

        Queriable<Integer> source = new ReferenceQueriable<>(numbers);
        Queriable<Integer> joiner = new ReferenceQueriable<>(numbers);
        Predicate<Integer> predicate = null;

        exception.expect(IllegalArgumentException.class);

        //noinspection ConstantConditions
        source.join(joiner, predicate);
    }
}
