package org.eclipse.collections.impl.clusters;

public class Cluster_942 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagTest._Benchmark _Benchmark_benchmark_5;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_942() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.toImmutableSortedSetBy);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.toImmutableSortedSet_with_comparator);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.toImmutableSortedSetBy);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.toImmutableSortedSet_with_comparator);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.toImmutableSortedSetBy);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.toSortedSet_with_comparator);
        }

   }

}