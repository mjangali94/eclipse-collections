package org.eclipse.collections.impl.clusters;

public class Cluster_265 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.map.mutable.primitive.IntBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.map.mutable.primitive.CharBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.map.mutable.primitive.ShortBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_5;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.map.mutable.primitive.IntBooleanHashMapValuesTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.map.mutable.primitive.CharBooleanHashMapValuesTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.map.mutable.primitive.ShortBooleanHashMapValuesTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_265() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.newCollectionWith);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.notEmpty);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.addAllIterable);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.withAll);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.withoutAll);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.withoutAll);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.withAll);
        }

   }

}