/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.block.factory;

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.multimap.list.MutableListMultimap;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class MultimapFunctionsTest {

    @Test
    public void get() {
        MutableListMultimap<String, String> multimap = FastListMultimap.newMultimap();
        multimap.putAll("One", FastList.newListWith("O", "N", "E"));
        multimap.putAll("Two", FastList.newListWith("T", "W", "O"));
        multimap.putAll("Three", FastList.newListWith("T", "H", "R", "E", "E"));
        Function<String, RichIterable<String>> getFunction = MultimapFunctions.get(multimap);
        Assert.assertEquals(FastList.newListWith(FastList.newListWith("O", "N", "E"), FastList.newListWith("T", "W", "O"), FastList.newListWith("T", "H", "R", "E", "E")), FastList.newListWith("One", "Two", "Three").collect(getFunction));
    }

    @Test
    public void classIsNonInstantiable() {
        Verify.assertClassNonInstantiable(MultimapFunctions.class);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MultimapFunctionsTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_classIsNonInstantiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.classIsNonInstantiable);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MultimapFunctionsTest> payload) throws java.lang.Throwable {
            this.instance = new MultimapFunctionsTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultimapFunctionsTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultimapFunctionsTest> classIsNonInstantiable;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.get = MultimapFunctionsTest::get;
            this.payloads.classIsNonInstantiable = MultimapFunctionsTest::classIsNonInstantiable;
        }
    }
*/
}
