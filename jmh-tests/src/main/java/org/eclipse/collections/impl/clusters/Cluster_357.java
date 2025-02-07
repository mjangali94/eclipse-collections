package org.eclipse.collections.impl.clusters;

public class Cluster_357 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.immutable.ImmutableSextupletonListTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.mutable.FastListAsUnmodifiableTest._Benchmark _Benchmark_benchmark_8;
       private org.eclipse.collections.impl.bag.immutable.ImmutableEmptyBagTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.list.immutable.ImmutableSeptupletonListTest._Benchmark _Benchmark_benchmark_10;
       private org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark _Benchmark_benchmark_12;
       private org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark _Benchmark_benchmark_14;
       private org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark _Benchmark_benchmark_15;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark _Benchmark_benchmark_16;
       private org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark _Benchmark_benchmark_23;
       private org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark _Benchmark_benchmark_31;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.immutable.ImmutableSextupletonListTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.list.mutable.FastListAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.bag.immutable.ImmutableEmptyBagTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.list.immutable.ImmutableSeptupletonListTest._Benchmark();
            _Benchmark_benchmark_12 = new org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark();
            _Benchmark_benchmark_14 = new org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark();
            _Benchmark_benchmark_15 = new org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark();
            _Benchmark_benchmark_16 = new org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark();
            _Benchmark_benchmark_23 = new org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark();
            _Benchmark_benchmark_31 = new org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_12.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_14.makePayloads();
            this._Benchmark_benchmark_15.makePayloads();
            this._Benchmark_benchmark_16.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_12.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_14.makePayloads();
            this._Benchmark_benchmark_23.makePayloads();
            this._Benchmark_benchmark_12.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_23.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_31.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_357() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.reverseThis);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collectIf);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.toSortedSet);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.tap);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.collectWith);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.sortThisByBoolean);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.rejectWithIndex);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.selectWithIndex);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.collectIf);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.collectIfWithTarget);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.collect);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.binarySearch);
            this._Benchmark_benchmark_12.runBenchmark(this._Benchmark_benchmark_12.payloads.tap);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.each);
            this._Benchmark_benchmark_14.runBenchmark(this._Benchmark_benchmark_14.payloads.each);
            this._Benchmark_benchmark_15.runBenchmark(this._Benchmark_benchmark_15.payloads.partition);
            this._Benchmark_benchmark_16.runBenchmark(this._Benchmark_benchmark_16.payloads.toSortedSet);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.collectIfWithTarget);
            this._Benchmark_benchmark_12.runBenchmark(this._Benchmark_benchmark_12.payloads.containsAll);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.selectWithIndex);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.rejectWithIndex);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.collectIf);
            this._Benchmark_benchmark_14.runBenchmark(this._Benchmark_benchmark_14.payloads.dropWhile);
            this._Benchmark_benchmark_23.runBenchmark(this._Benchmark_benchmark_23.payloads.getOnly);
            this._Benchmark_benchmark_12.runBenchmark(this._Benchmark_benchmark_12.payloads.collectWith_target);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.collectWith);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.chunk_large_size);
            this._Benchmark_benchmark_23.runBenchmark(this._Benchmark_benchmark_23.payloads.getAny);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.select);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.reject);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.toSortedSet);
            this._Benchmark_benchmark_31.runBenchmark(this._Benchmark_benchmark_31.payloads.collect);
        }

   }

}