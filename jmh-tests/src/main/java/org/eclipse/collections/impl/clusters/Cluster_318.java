package org.eclipse.collections.impl.clusters;

public class Cluster_318 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplNoIteratorTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.multimap.bag.strategy.HashBagMultimapWithHashingStrategyTest._Benchmark _Benchmark_benchmark_3;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplNoIteratorTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.multimap.bag.strategy.HashBagMultimapWithHashingStrategyTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_318() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.toImmutableSortedBag_natural_ordering);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.rejectWith_target);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.selectWith_target);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.putAllFromIterable);
        }

   }

}