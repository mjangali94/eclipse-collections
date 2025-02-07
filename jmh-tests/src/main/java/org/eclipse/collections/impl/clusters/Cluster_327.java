package org.eclipse.collections.impl.clusters;

public class Cluster_327 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.mutable.ListAdapterAsUnmodifiableTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark _Benchmark_benchmark_8;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark _Benchmark_benchmark_15;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.mutable.ListAdapterAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark();
            _Benchmark_benchmark_15 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_15.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_327() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.min);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.containsAllArray);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.removeIf);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.max);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.containsAllArray);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.withoutAll);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.withAll);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.replaceAll);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.toSortedListWithComparator);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.toArray);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.toMapTarget);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.countWith);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.toSortedList_with_comparator);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.toSortedListBy);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.sort);
            this._Benchmark_benchmark_15.runBenchmark(this._Benchmark_benchmark_15.payloads.withMethods);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.injectInto);
        }

   }

}