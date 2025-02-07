package org.eclipse.collections.impl.clusters;

public class Cluster_77 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.immutable.ImmutableEmptyBagTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.bag.immutable.ImmutableHashBagTest._Benchmark _Benchmark_benchmark_6;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bag.immutable.ImmutableEmptyBagTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.bag.immutable.ImmutableHashBagTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_77() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.forEach);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.countByEach_target);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.getOnly_empty_throws);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.anySatisfyWith);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.detectWithIfNoneBlock);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.detectWithIfNoneBlock);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.detectWithIfNoneBlock);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.noneSatisfyWith);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.allSatisfyWith);
        }

   }

}