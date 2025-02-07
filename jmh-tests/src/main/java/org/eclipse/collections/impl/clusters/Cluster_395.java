package org.eclipse.collections.impl.clusters;

public class Cluster_395 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplNoIteratorTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bag.immutable.ImmutableArrayBagTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark _Benchmark_benchmark_11;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplNoIteratorTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.bag.immutable.ImmutableArrayBagTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark();
            _Benchmark_benchmark_11 = new org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_395() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.forEachWith);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.toSortedListBy);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.flatCollectInt);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.tap);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.tap);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.rejectWith_target);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.selectAndRejectWith);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.forEachWith);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.collectWithIndexWithTarget);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.tap);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.toSortedList);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.rejectWith);
        }

   }

}