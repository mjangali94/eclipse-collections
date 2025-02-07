package org.eclipse.collections.impl.clusters;

public class Cluster_812 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.bag.immutable.ImmutableEmptyBagTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark _Benchmark_benchmark_8;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark _Benchmark_benchmark_9;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bag.immutable.ImmutableEmptyBagTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_812() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.minOptional);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.minOptional);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.collectBooleanWithTarget);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.min);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.flatCollectWithTarget);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.countByEach);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.maxOptional);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.selectDuplicates);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.newWithout);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.retainAll);
        }

   }

}