package org.eclipse.collections.impl.clusters;

public class Cluster_616 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark _Benchmark_benchmark_3;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_616() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectDouble);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectShort);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.collectByteWithTarget);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.collectByteWithTarget);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.collectByte);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.collectByte);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.collectFloatWithTarget);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.collectFloatWithTarget);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.collectDoubleWithTarget);
        }

   }

}