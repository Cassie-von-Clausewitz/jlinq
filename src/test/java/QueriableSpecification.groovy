import collections.ReferenceQueriable
import spock.lang.Specification

import java.util.function.BiPredicate

/**
 * Created by kriedema on 1/26/17.
 */
class QueriableSpecification extends Specification {
    def "can chain operations"() {
        setup:
            def numbers = [ 1, 3, 7, 9, 10, 11, 16, 18, 20, 31 ]
            def joinable = [ 1, 3, 17, 18, 19, 20, 88 ]
            def expected = [ 18, 20 ]

            def source = new ReferenceQueriable<>(numbers)
            def joiner = new ReferenceQueriable<>(joinable)
            BiPredicate<Integer, Integer> predicate = { num1, num2 -> num1 == num2 }

        when:
            def result = source.join(joiner, predicate).where({ num -> num > 5 })

        then:
            result == expected
    }
}
