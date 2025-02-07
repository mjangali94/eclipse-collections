package org.eclipse.collections.impl.clusters;

public class Cluster_1024 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark _Benchmark_benchmark_6;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_1024() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.getIfAbsentPut);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.getIfAbsentPut);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.getIfAbsentWith);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.getIfAbsent);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.getOrDefault);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.ifPresentApply);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.ifPresentApply);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.getIfAbsent_function);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.getIfAbsentWith);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.getOrDefault);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.getIfAbsentWith);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.getOrDefault);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.getIfAbsent);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.getIfAbsent);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.getIfAbsentPutWith_block_throws);
        }

   }

}