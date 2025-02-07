package org.eclipse.collections.impl.clusters;

public class Cluster_880 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.mutable.primitive.SynchronizedBooleanBagTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bag.immutable.ImmutableHashBagTest._Benchmark _Benchmark_benchmark_3;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bag.mutable.primitive.SynchronizedBooleanBagTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.bag.immutable.ImmutableHashBagTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_880() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.withAll);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.topOccurrences);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.newWithAll);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.collectIfWithTarget);
        }

   }

}