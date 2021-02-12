/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.list.mutable;

import java.util.ArrayList;
import org.eclipse.collections.api.list.MutableList;

public class ArrayListAdapterAsUnmodifiableTest extends UnmodifiableMutableListTestCase {

    @Override
    protected MutableList<Integer> getCollection() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        return ArrayListAdapter.adapt(list).asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        private ArrayListAdapterAsUnmodifiableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new ArrayListAdapterAsUnmodifiableTest();
        }

        @java.lang.Override
        public ArrayListAdapterAsUnmodifiableTest implementation() {
            return this.implementation;
        }
    }
}
