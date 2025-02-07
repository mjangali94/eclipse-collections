package org.eclipse.collections.impl.clusters;

public class Cluster_434 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.map.mutable.primitive.LongBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.map.mutable.primitive.UnmodifiableLongBooleanMapValuesTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.map.mutable.primitive.DoubleBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_6;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.map.mutable.primitive.LongBooleanHashMapValuesTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.map.mutable.primitive.UnmodifiableLongBooleanMapValuesTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.map.mutable.primitive.DoubleBooleanHashMapValuesTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_434() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.reduceIfEmpty);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.addAllArray);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.withoutAll);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.addAllIterable);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.withAll);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.isEmpty);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.containsNoneArray);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.injectInto);
        }

   }

}