package collections;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public interface Queriable<T> extends List {
    Queriable<T> where(Predicate<? super T> predicate);

    Queriable<T> join(Queriable<? super T> queriable, BiPredicate<T, ? super T> predicate);
}
