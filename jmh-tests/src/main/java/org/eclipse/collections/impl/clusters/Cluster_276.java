package org.eclipse.collections.impl.clusters;

public class Cluster_276 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark _Benchmark_benchmark_8;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_276() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.withMapIterableEmptyAndTargetEmpty);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.keySetToArray);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.keySetToArray);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.clear);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.clearEntrySet);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.clearKeySet);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.clearKeySet);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.clearEntrySet);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.putAllMapIterable);
        }

   }

}