package org.eclipse.collections.impl.clusters;

public class Cluster_369 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.immutable.ImmutableHashBagTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark _Benchmark_benchmark_8;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bag.immutable.ImmutableHashBagTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_369() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.countBy);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.countByWith);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.clear);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.toImmutable);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.toSortedList_natural_ordering);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.toSortedList_natural_ordering);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.toMapTarget);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.countByWith);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.getLast);
        }

   }

}