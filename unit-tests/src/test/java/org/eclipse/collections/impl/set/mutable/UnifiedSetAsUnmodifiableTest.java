/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.set.mutable;

import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.impl.collection.mutable.UnmodifiableMutableCollectionTestCase;

public class UnifiedSetAsUnmodifiableTest extends UnmodifiableMutableCollectionTestCase<Integer> {

    @Override
    protected MutableCollection<Integer> getCollection() {
        return UnifiedSet.newSetWith(1).asUnmodifiable();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        private UnifiedSetAsUnmodifiableTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new UnifiedSetAsUnmodifiableTest();
        }

        @java.lang.Override
        public UnifiedSetAsUnmodifiableTest implementation() {
            return this.implementation;
        }
    }
}
