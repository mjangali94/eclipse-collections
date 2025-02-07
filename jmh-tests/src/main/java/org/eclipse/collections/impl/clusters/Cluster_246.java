package org.eclipse.collections.impl.clusters;

public class Cluster_246 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark _Benchmark_benchmark_7;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_246() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.anySatisfyWith);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.noneSatisfyWith);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.addAll);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.toImmutableSortedSet_with_comparator);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.addAll);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.toCollection);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.toCollection);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.containsAllIterable);
        }

   }

}