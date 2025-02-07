package org.eclipse.collections.impl.clusters;

public class Cluster_256 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplNoIteratorTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.immutable.ImmutableArrayBagTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark _Benchmark_benchmark_4;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplNoIteratorTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bag.immutable.ImmutableArrayBagTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_256() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.countByWith);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.countBy);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.collectBoolean);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.selectDuplicates);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.removeOccurrences);
        }

   }

}