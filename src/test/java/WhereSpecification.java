import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.function.Predicate;

import collections.Queriable;
import collections.ReferenceQueriable;
import spock.lang.Specification;

public class WhereSpecification extends Specification {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void NullPredicateThrowsNullArgumentException()
    {
        Integer[] numbers = { 1, 3, 7, 9, 10 };

        Queriable<Integer> source = new ReferenceQueriable<>(numbers);
        Predicate<Integer> predicate = null;

        exception.expect(IllegalArgumentException.class);

        //noinspection ConstantConditions
        source.where(predicate);
    }

    @Test
    public void SimpleFiltering()
    {
        Integer[] numbers = { 1, 3, 4, 2, 8, 1 };

        Queriable<Integer> source = new ReferenceQueriable<>(numbers);

        Queriable<Integer> result = source.where(x -> x < 4);
        Integer[] expected = {1, 3, 2, 1};

        Assert.assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void EmptySource()
    {
        Integer[] numbers = {};
        Queriable<Integer> source = new ReferenceQueriable<>(numbers);

        Queriable<Integer> result = source.where(x -> x < 4);

        Assert.assertArrayEquals(numbers, result.toArray());
    }

    @Test
    public void ExecutionIsDeferred()
    {
        // todo figure out how to test this in java
    }
}
