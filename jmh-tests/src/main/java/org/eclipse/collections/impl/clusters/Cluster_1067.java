package org.eclipse.collections.impl.clusters;

public class Cluster_1067 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplNoIteratorTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplTest._Benchmark _Benchmark_benchmark_5;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplNoIteratorTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_1067() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.injectIntoInt);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.testNewWith);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.take_throws);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.castToCollection);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.drop_throws);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.min_without_comparator);
        }

   }

}