package org.eclipse.collections.impl.clusters;

public class Cluster_271 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.multimap.bag.sorted.immutable.ImmutableSortedBagMultimapImplTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.bag.immutable.ImmutableArrayBagTest._Benchmark _Benchmark_benchmark_6;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.multimap.bag.sorted.immutable.ImmutableSortedBagMultimapImplTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.bag.immutable.ImmutableArrayBagTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_271() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.testNewWithVarArgs);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.testNewWithWith);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.testNewWithWithWith);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.notEmpty);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.size);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.toImmutableSortedBag_with_comparator);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.toImmutableSortedBag_with_comparator);
        }

   }

}