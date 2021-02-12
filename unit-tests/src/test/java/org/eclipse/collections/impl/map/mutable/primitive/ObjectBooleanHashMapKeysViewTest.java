/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.lazy.AbstractLazyIterableTestCase;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ObjectBooleanHashMap#keysView()}.
 */
public class ObjectBooleanHashMapKeysViewTest extends AbstractLazyIterableTestCase {

    @Override
    protected <T> LazyIterable<T> newWith(T... elements) {
        ObjectBooleanHashMap<T> map = new ObjectBooleanHashMap<>();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], (i & 1) == 0);
        }
        return map.keysView();
    }

    @Override
    @Test
    public void iterator() {
        MutableSet<String> expected = UnifiedSet.newSetWith("zero", "thirtyOne", "thirtyTwo");
        MutableSet<String> actual = UnifiedSet.newSet();
        Iterator<String> iterator = ObjectBooleanHashMap.newWithKeysValues("zero", true, "thirtyOne", false, "thirtyTwo", true).keysView().iterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        private ObjectBooleanHashMapKeysViewTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ObjectBooleanHashMapKeysViewTest();
        }

        @java.lang.Override
        public ObjectBooleanHashMapKeysViewTest implementation() {
            return this.implementation;
        }
    }
}
