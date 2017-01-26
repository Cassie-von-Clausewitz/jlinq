import groovy.lang.Grab;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.function.Predicate;

import collections.Queriable;
import collections.ReferenceQueriable;
import spock.lang.Specification;

import spock.lang.Specification;

import spock.lang.*;

class WhereSpecification extends Specification {

    def "null predicate throws null argument excpetion"() {
        setup:
            Integer[] numbers = [1, 3, 7, 9, 10]

            def source = new ReferenceQueriable<>(numbers)
            Predicate<Integer> predicate = null

        when:
            source.where(predicate)

        then:
            thrown IllegalArgumentException
    }

    def "can filter with predicate"() {
        setup:
            Integer[] numbers = [1, 3, 4, 2, 8, 1]

            def source = new ReferenceQueriable<>(numbers)

        when:
            def result = source.where({x -> x < 4})

        then:
            result == [ 1, 3, 2, 1 ]
    }

    def "empty source returns empty result for valid predicate"() {
        setup:
            Integer[] numbers = []
            def source = new ReferenceQueriable(numbers)

        when:
            def result = source.where({x -> x < 4})

        then:
            result.isEmpty()
    }

    @Test
    public void ExecutionIsDeferred() {
        // todo figure out how to test this in java
    }
}
