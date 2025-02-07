package org.eclipse.collections.impl.clusters;

public class Cluster_98 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_9;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_98() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.minOptional);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.testForEachWithIndexWithFromToWithCommandoPatternOptimization);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.forEach);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.replaceAll);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.reverseForEachWithIndex);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.distinct);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.testInjectIntoMinString);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.testInjectIntoMaxString);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.testSubListSort);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.addAll);
        }

   }

}