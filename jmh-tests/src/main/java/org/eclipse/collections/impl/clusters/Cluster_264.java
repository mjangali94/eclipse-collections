package org.eclipse.collections.impl.clusters;

public class Cluster_264 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.map.mutable.primitive.IntBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.map.mutable.primitive.ShortBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.map.mutable.primitive.CharBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_6;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.map.mutable.primitive.IntBooleanHashMapValuesTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.map.mutable.primitive.ShortBooleanHashMapValuesTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.map.mutable.primitive.CharBooleanHashMapValuesTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_264() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.withAll);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.withoutAll);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.addAllIterable);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.containsNoneArray);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.injectInto);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.without);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.without);
        }

   }

}