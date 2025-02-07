package org.eclipse.collections.impl.clusters;

public class Cluster_70 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark _Benchmark_benchmark_11;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            _Benchmark_benchmark_11 = new org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_70() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.randomAccess_throws);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.randomAccess_throws);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.summarizeInt);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.minBy_null_throws);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.summarizeLong);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.contains);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.maxBy_null_throws);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.randomAccess_throws);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.detectOptional);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.summarizeFloat);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.summarizeDouble);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.randomAccess_throws);
        }

   }

}