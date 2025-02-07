package org.eclipse.collections.impl.clusters;

public class Cluster_211 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.mutable.FastListAsUnmodifiableTest._Benchmark _Benchmark_benchmark_5;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayListTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.mutable.FastListAsUnmodifiableTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_211() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectWithIndex);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.sortThisBy);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.sortThis_with_comparator);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.sortThis_with_comparator_small);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.asSynchronized);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.retainAll);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.without);
        }

   }

}