/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable.primitive;

import org.eclipse.collections.api.iterator.MutableBooleanIterator;
import org.eclipse.collections.api.set.primitive.MutableBooleanSet;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableBooleanSet}.
 */
public class UnmodifiableBooleanSetTest extends AbstractBooleanSetTestCase {

    @Override
    protected final UnmodifiableBooleanSet classUnderTest() {
        return new UnmodifiableBooleanSet(BooleanHashSet.newSetWith(true, false, true));
    }

    @Override
    protected UnmodifiableBooleanSet newWith(boolean... elements) {
        return new UnmodifiableBooleanSet(BooleanHashSet.newSetWith(elements));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        this.classUnderTest().clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add() {
        this.newWith().add(true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray() {
        this.classUnderTest().addAll(true, false, true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable() {
        this.classUnderTest().addAll(this.newMutableCollectionWith());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.classUnderTest().remove(false);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() {
        this.classUnderTest().removeAll(true, false);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll_iterable() {
        this.classUnderTest().removeAll(this.newMutableCollectionWith());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll() {
        this.classUnderTest().retainAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll_iterable() {
        this.classUnderTest().retainAll(this.newMutableCollectionWith());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with() {
        this.newWith().with(true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll() {
        this.newWith().withAll(this.newMutableCollectionWith(true));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without() {
        this.newWith(true, false, true, false, true).without(true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll() {
        this.newWith(true, false, true, false, true).withoutAll(this.newMutableCollectionWith(false, false));
    }

    @Override
    @Test
    public void containsAllArray() {
        UnmodifiableBooleanSet collection = this.classUnderTest();
        Assert.assertTrue(collection.containsAll(true));
        Assert.assertTrue(collection.containsAll(true, false, true));
        Assert.assertTrue(collection.containsAll(true, false));
        Assert.assertTrue(collection.containsAll(true, true));
        Assert.assertTrue(collection.containsAll(false, false));
        UnmodifiableBooleanSet emptyCollection = this.newWith();
        Assert.assertFalse(emptyCollection.containsAll(true));
        Assert.assertFalse(emptyCollection.containsAll(false));
        Assert.assertFalse(emptyCollection.containsAll(false, true, false));
        Assert.assertFalse(this.newWith(true, true).containsAll(false, true, false));
        UnmodifiableBooleanSet trueCollection = this.newWith(true, true, true, true);
        Assert.assertFalse(trueCollection.containsAll(true, false));
        UnmodifiableBooleanSet falseCollection = this.newWith(false, false, false, false);
        Assert.assertFalse(falseCollection.containsAll(true, false));
    }

    @Override
    @Test
    public void containsAllIterable() {
        UnmodifiableBooleanSet emptyCollection = this.newWith();
        Assert.assertTrue(emptyCollection.containsAll(new BooleanArrayList()));
        Assert.assertFalse(emptyCollection.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(emptyCollection.containsAll(BooleanArrayList.newListWith(false)));
        UnmodifiableBooleanSet collection = this.newWith(true, true, false, false, false);
        Assert.assertTrue(collection.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertTrue(collection.containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(collection.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(collection.containsAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertTrue(collection.containsAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertTrue(collection.containsAll(BooleanArrayList.newListWith(true, false, true)));
        Assert.assertFalse(this.newWith(true, true).containsAll(BooleanArrayList.newListWith(false, true, false)));
        UnmodifiableBooleanSet trueCollection = this.newWith(true, true, true, true);
        Assert.assertFalse(trueCollection.containsAll(BooleanArrayList.newListWith(true, false)));
        UnmodifiableBooleanSet falseCollection = this.newWith(false, false, false, false);
        Assert.assertFalse(falseCollection.containsAll(BooleanArrayList.newListWith(true, false)));
    }

    @Override
    @Test
    public void asUnmodifiable() {
        super.asUnmodifiable();
        MutableBooleanSet set = this.classUnderTest();
        Assert.assertSame(set, set.asUnmodifiable());
        Assert.assertEquals(set, set.asUnmodifiable());
    }

    @Override
    @Test
    public void booleanIterator_with_remove() {
        MutableBooleanIterator booleanIterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(booleanIterator.hasNext());
        booleanIterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, booleanIterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_invocation_of_remove_before_next() {
        MutableBooleanIterator booleanIterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(booleanIterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, booleanIterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
    // Not applicable for Unmodifiable*
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::clear, this.description("clear"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::add, this.description("add"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addAllArray, this.description("addAllArray"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::addAllIterable, this.description("addAllIterable"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::remove, this.description("remove"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeAll, this.description("removeAll"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll_iterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::removeAll_iterable, this.description("removeAll_iterable"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::retainAll, this.description("retainAll"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll_iterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::retainAll_iterable, this.description("retainAll_iterable"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::with, this.description("with"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::withAll, this.description("withAll"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::without, this.description("without"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::withoutAll, this.description("withoutAll"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAllArray, this.description("containsAllArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAllIterable, this.description("containsAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asUnmodifiable, this.description("asUnmodifiable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_booleanIterator_with_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::booleanIterator_with_remove, this.description("booleanIterator_with_remove"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_invocation_of_remove_before_next() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator_throws_on_invocation_of_remove_before_next, this.description("iterator_throws_on_invocation_of_remove_before_next"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws_on_consecutive_invocation_of_remove() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator_throws_on_consecutive_invocation_of_remove, this.description("iterator_throws_on_consecutive_invocation_of_remove"));
        }

        private UnmodifiableBooleanSetTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnmodifiableBooleanSetTest();
        }

        @java.lang.Override
        public UnmodifiableBooleanSetTest implementation() {
            return this.implementation;
        }
    }
}
