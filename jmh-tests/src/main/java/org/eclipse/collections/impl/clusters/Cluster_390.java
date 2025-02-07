package org.eclipse.collections.impl.clusters;

public class Cluster_390 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.list.immutable.ImmutableSeptupletonListTest._Benchmark _Benchmark_benchmark_10;
       private org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark _Benchmark_benchmark_11;
       private org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark _Benchmark_benchmark_13;
       private org.eclipse.collections.impl.list.immutable.ImmutableSextupletonListTest._Benchmark _Benchmark_benchmark_20;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.list.immutable.ImmutableSeptupletonListTest._Benchmark();
            _Benchmark_benchmark_11 = new org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark();
            _Benchmark_benchmark_13 = new org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark();
            _Benchmark_benchmark_20 = new org.eclipse.collections.impl.list.immutable.ImmutableSextupletonListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_20.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_390() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectWith);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collectWith_target);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.collectIf);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.min_empty_throws);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.collectIfWithTarget);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.asReversed);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.tap);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.collectWith);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.collectWith_target);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collectWith);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.toSortedSet);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.each);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.forEachWith);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.collect);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.collectIf);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.tap);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.toList);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.toSortedSet);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.forEachWith);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.collectWith_target);
            this._Benchmark_benchmark_20.runBenchmark(this._Benchmark_benchmark_20.payloads.collectWith);
        }

   }

}