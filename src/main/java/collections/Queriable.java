package collections;

import java.util.List;
import java.util.function.Predicate;

public interface Queriable<T> extends List {
    Queriable<T> where(Predicate<? super T> predicate);

    Queriable<T> join(Queriable<? super T> queriable, Predicate<? super T> predicate);
}
