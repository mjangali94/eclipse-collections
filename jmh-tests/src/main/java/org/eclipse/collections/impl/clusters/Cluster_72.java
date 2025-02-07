package org.eclipse.collections.impl.clusters;

public class Cluster_72 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark _Benchmark_benchmark_3;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_72() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.removeAll);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.retainAll);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.addAll);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.min);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.max_without_comparator);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.max);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.min_without_comparator);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.minBy);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.detectIfNone);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.toSortedListWithNullWithNoComparator);
        }

   }

}