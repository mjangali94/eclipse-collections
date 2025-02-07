package org.eclipse.collections.impl.clusters;

public class Cluster_262 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bimap.mutable.HashBiMapKeySetTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseKeySetTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.map.mutable.primitive.SynchronizedByteBooleanMapValuesTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.map.mutable.primitive.UnmodifiableLongBooleanMapValuesTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.map.mutable.primitive.UnmodifiableIntBooleanMapValuesTest._Benchmark _Benchmark_benchmark_4;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapKeySetTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseKeySetTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.map.mutable.primitive.SynchronizedByteBooleanMapValuesTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.map.mutable.primitive.UnmodifiableLongBooleanMapValuesTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.map.mutable.primitive.UnmodifiableIntBooleanMapValuesTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_262() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.keySetToArray);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.keySetToArray);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.collect);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.collect);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.collect);
        }

   }

}