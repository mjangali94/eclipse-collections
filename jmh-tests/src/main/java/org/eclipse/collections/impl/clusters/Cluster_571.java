package org.eclipse.collections.impl.clusters;

public class Cluster_571 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.immutable.ImmutableArrayBagTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bag.immutable.ImmutableHashBagTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark _Benchmark_benchmark_10;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.immutable.ImmutableArrayBagTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.bag.immutable.ImmutableHashBagTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_571() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.fusedCollectMakeString);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.countByWith);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.countBy);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.count);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.countBy);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.toSortedList_with_null);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.toImmutableSortedListBy);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.toImmutableSortedList_with_comparator);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.maxBy_null_throws);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.minBy_null_throws);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.maxBy_null_throws);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.minBy_null_throws);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.toStringOfItemToCount);
        }

   }

}