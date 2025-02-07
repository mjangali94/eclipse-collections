package org.eclipse.collections.impl.clusters;

public class Cluster_729 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsReadUntouchableTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_8;
       private org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark _Benchmark_benchmark_15;
       private org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark _Benchmark_benchmark_16;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_19;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark _Benchmark_benchmark_21;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsReadUntouchableTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark();
            _Benchmark_benchmark_15 = new org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark();
            _Benchmark_benchmark_16 = new org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark();
            _Benchmark_benchmark_19 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            _Benchmark_benchmark_21 = new org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_15.makePayloads();
            this._Benchmark_benchmark_16.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_21.makePayloads();
            this._Benchmark_benchmark_21.makePayloads();
            this._Benchmark_benchmark_21.makePayloads();
            this._Benchmark_benchmark_21.makePayloads();
            this._Benchmark_benchmark_21.makePayloads();
            this._Benchmark_benchmark_21.makePayloads();
            this._Benchmark_benchmark_21.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_729() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectWith);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.reverseForEachWithIndex);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.each);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.forEachWith);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.reverseForEachWithIndex);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.max_null_safe);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.without);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.min_null_safe);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.toSortedListBy);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.collectFloat);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.collectChar);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.collectLong);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.reverseForEachWithIndex);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.collectByte);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.collectDouble);
            this._Benchmark_benchmark_15.runBenchmark(this._Benchmark_benchmark_15.payloads.toSortedListWith);
            this._Benchmark_benchmark_16.runBenchmark(this._Benchmark_benchmark_16.payloads.each);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.max_null_throws_without_comparator);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.max_null_throws);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.countWith);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.maxOptional);
            this._Benchmark_benchmark_21.runBenchmark(this._Benchmark_benchmark_21.payloads.reverseForEachWithIndex);
            this._Benchmark_benchmark_21.runBenchmark(this._Benchmark_benchmark_21.payloads.collectChar);
            this._Benchmark_benchmark_21.runBenchmark(this._Benchmark_benchmark_21.payloads.collectShort);
            this._Benchmark_benchmark_21.runBenchmark(this._Benchmark_benchmark_21.payloads.collectDouble);
            this._Benchmark_benchmark_21.runBenchmark(this._Benchmark_benchmark_21.payloads.collectFloat);
            this._Benchmark_benchmark_21.runBenchmark(this._Benchmark_benchmark_21.payloads.collectByte);
            this._Benchmark_benchmark_21.runBenchmark(this._Benchmark_benchmark_21.payloads.collectLong);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.forEachInBoth);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collectFloat);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collectChar);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collectLong);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collectByte);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collectDouble);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collectShort);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.each);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.contains);
        }

   }

}