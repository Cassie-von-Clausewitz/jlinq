import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException
import spock.lang.Specification

import java.util.function.BiFunction
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import collections.Queriable;
import collections.ReferenceQueriable;

class JoinSpecification extends Specification {

    def "null function throws null argument exception"() {
        setup:
            Integer[] numbers = [ 1, 3, 7, 9, 10 ]

            def source = new ReferenceQueriable<>(numbers)
            def joiner = new ReferenceQueriable<>(numbers)
            BiPredicate<Integer, Integer> predicate = null

        when:
            source.join(joiner, predicate)

        then:
            thrown IllegalArgumentException
    }

    def "can join list of numbers with function"() {
        setup:
            def numbers = [ 1, 3, 7, 9, 10, 11, 16, 18, 20, 31 ]
            def joinable = [ 1, 3, 17, 18, 19, 20, 88 ]
            def expected = [ 1, 3, 18, 20 ]

            def source = new ReferenceQueriable<>(numbers)
            def joiner = new ReferenceQueriable<>(joinable)
            BiPredicate<Integer, Integer> predicate = { num1, num2 -> num1 == num2 }

        when:
            def result = source.join(joiner, predicate)

        then:
            result == expected
    }
}
