package org.eclipse.collections.impl.clusters;

public class Cluster_792 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.immutable.ImmutableSextupletonListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsReadUntouchableTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark _Benchmark_benchmark_8;
       private org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark _Benchmark_benchmark_10;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark _Benchmark_benchmark_11;
       private org.eclipse.collections.impl.list.immutable.ImmutableSeptupletonListTest._Benchmark _Benchmark_benchmark_18;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_23;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.immutable.ImmutableSextupletonListTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsReadUntouchableTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_11 = new org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark();
            _Benchmark_benchmark_18 = new org.eclipse.collections.impl.list.immutable.ImmutableSeptupletonListTest._Benchmark();
            _Benchmark_benchmark_23 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_18.makePayloads();
            this._Benchmark_benchmark_18.makePayloads();
            this._Benchmark_benchmark_18.makePayloads();
            this._Benchmark_benchmark_18.makePayloads();
            this._Benchmark_benchmark_18.makePayloads();
            this._Benchmark_benchmark_23.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_792() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectLong);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectDouble);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectShort);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectByte);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectFloat);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectChar);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.zipWithIndex);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.tap);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.corresponds);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.toSortedSet_natural_ordering);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.collectByte);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.min_null_throws_without_comparator);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.collectShort);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.collectChar);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.collectDouble);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.toSortedSet_with_comparator);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.min_null_throws);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.collectFloat);
            this._Benchmark_benchmark_18.runBenchmark(this._Benchmark_benchmark_18.payloads.collectChar);
            this._Benchmark_benchmark_18.runBenchmark(this._Benchmark_benchmark_18.payloads.collectFloat);
            this._Benchmark_benchmark_18.runBenchmark(this._Benchmark_benchmark_18.payloads.collectByte);
            this._Benchmark_benchmark_18.runBenchmark(this._Benchmark_benchmark_18.payloads.collectShort);
            this._Benchmark_benchmark_18.runBenchmark(this._Benchmark_benchmark_18.payloads.collectDouble);
            this._Benchmark_benchmark_23.runBenchmark(this._Benchmark_benchmark_23.payloads.toImmutableSortedSetBy);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.max_null_throws_without_comparator);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.max_null_throws);
        }

   }

}