package org.eclipse.collections.impl.clusters;

public class Cluster_183 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_8;
       private org.eclipse.collections.impl.list.immutable.ImmutableEmptyListTest._Benchmark _Benchmark_benchmark_12;
       private org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark _Benchmark_benchmark_13;
       private org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark _Benchmark_benchmark_16;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark _Benchmark_benchmark_17;
       private org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark _Benchmark_benchmark_20;
       private org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark _Benchmark_benchmark_21;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            _Benchmark_benchmark_12 = new org.eclipse.collections.impl.list.immutable.ImmutableEmptyListTest._Benchmark();
            _Benchmark_benchmark_13 = new org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark();
            _Benchmark_benchmark_16 = new org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark();
            _Benchmark_benchmark_17 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_20 = new org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark();
            _Benchmark_benchmark_21 = new org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_12.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_16.makePayloads();
            this._Benchmark_benchmark_17.makePayloads();
            this._Benchmark_benchmark_16.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_20.makePayloads();
            this._Benchmark_benchmark_21.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_183() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.containsAllCollection);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.containsAllCollection);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.fusedCollectMakeString);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.sortThisWithNullWithNoComparator);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.toSortedListBy_with_null);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.fusedCollectMakeString);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.toSortedList_natural_ordering);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.fusedCollectMakeString);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.selectAndRejectWith);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.tap);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.selectWithIndex);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.rejectWithIndex);
            this._Benchmark_benchmark_12.runBenchmark(this._Benchmark_benchmark_12.payloads.toList);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.fusedCollectMakeString);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.tap);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.chunk_large_size);
            this._Benchmark_benchmark_16.runBenchmark(this._Benchmark_benchmark_16.payloads.collect);
            this._Benchmark_benchmark_17.runBenchmark(this._Benchmark_benchmark_17.payloads.collectIf);
            this._Benchmark_benchmark_16.runBenchmark(this._Benchmark_benchmark_16.payloads.collectIf);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.notEmpty);
            this._Benchmark_benchmark_20.runBenchmark(this._Benchmark_benchmark_20.payloads.sortThisByBoolean);
            this._Benchmark_benchmark_21.runBenchmark(this._Benchmark_benchmark_21.payloads.collect);
        }

   }

}