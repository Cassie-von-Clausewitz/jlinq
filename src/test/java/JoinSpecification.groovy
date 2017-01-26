import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException
import spock.lang.Specification;

import java.util.function.Predicate;

import collections.Queriable;
import collections.ReferenceQueriable;

public class JoinSpecification extends Specification {

    def "null predicate throws null argument exception"() {
        setup:
            Integer[] numbers = [ 1, 3, 7, 9, 10 ]

            def source = new ReferenceQueriable<>(numbers)
            def joiner = new ReferenceQueriable<>(numbers)
            Predicate<Integer> predicate = null

        when:
            source.join(joiner, predicate)

        then:
            thrown IllegalArgumentException
    }
}
