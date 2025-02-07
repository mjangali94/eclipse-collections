package org.eclipse.collections.impl.clusters;

public class Cluster_309 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.UnmodifiableMapEntrySetTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark _Benchmark_benchmark_8;
       private org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark _Benchmark_benchmark_11;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.UnmodifiableMapEntrySetTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark();
            _Benchmark_benchmark_11 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_309() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.toMap);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.toMap);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.aggregateByMutating);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.groupByUniqueKey_throws_for_duplicate);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.groupByUniqueKey_target);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.groupByUniqueKey_target_throws_for_duplicate);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.testNewWithVarArgs);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.groupByUniqueKey_target);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.groupByUniqueKey_target);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.groupByUniqueKey_target);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.toMap);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.aggregateByNonMutating);
        }

   }

}