package org.eclipse.collections.impl.clusters;

public class Cluster_2 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.map.mutable.primitive.CharBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.map.mutable.primitive.FloatBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.map.mutable.primitive.IntBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_2;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.map.mutable.primitive.CharBooleanHashMapValuesTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.map.mutable.primitive.FloatBooleanHashMapValuesTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.map.mutable.primitive.IntBooleanHashMapValuesTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_2() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.add);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.without);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.reduce);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.with);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.add);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.addAllArray);
        }

   }

}