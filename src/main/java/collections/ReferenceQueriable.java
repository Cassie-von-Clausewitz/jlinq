package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ReferenceQueriable<T> implements Queriable<T> {

    private List<T> backingList;

    public ReferenceQueriable() {
        backingList = new ArrayList<>();
    }

    public ReferenceQueriable(T[] array) {
        backingList = new ArrayList<>(Arrays.asList(array));
    }

    public ReferenceQueriable(List<T> list) {
        backingList = list;
    }

    @Override
    public Queriable<T> where(Predicate<? super T> predicate) {
        if (predicate == null) throw new IllegalArgumentException();

        List<T> list = new ArrayList<>();

        for (T item : backingList) {
            if (predicate.test(item)) {
                list.add(item);
            }
        }

        this.backingList = list;

        return this;
    }

    @Override
    public Queriable<T> join(Queriable<? super T> queriable, BiPredicate<T, ? super T> predicate) {
        if (predicate == null) throw new IllegalArgumentException();

        List<T> list = new ArrayList<>();

        for(T item : this.backingList) {
            for (Object joinable : queriable) {
                boolean result = predicate.test(item, (T)joinable);
                if (result) {
                    list.add(item);
                }
            }
        }

        return new ReferenceQueriable<>(list);
    }

    @Override
    public int size() {
        return backingList.size();
    }

    @Override
    public boolean isEmpty() {
        return backingList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return backingList.contains(o);
    }

    @Override
    public Iterator iterator() {
        return backingList.iterator();
    }

    @Override
    public Object[] toArray() {
        return backingList.toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return backingList.toArray(a);
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }
}
