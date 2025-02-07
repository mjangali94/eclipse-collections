package org.eclipse.collections.impl.clusters;

public class Cluster_849 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark _Benchmark_benchmark_8;
       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark _Benchmark_benchmark_9;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_849() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.withKeysValues);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.injectIntoInt);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.injectIntoDouble);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.injectIntoFloat);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.injectIntoLong);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.max);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.injectInto);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.withMapEmpty);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.count);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.count);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.withMapEmpty);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.allSatisfyWith);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.anySatisfyWith);
        }

   }

}