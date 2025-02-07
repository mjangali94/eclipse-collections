package org.eclipse.collections.impl.clusters;

public class Cluster_1036 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapValuesTest._Benchmark _Benchmark_benchmark_10;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseValuesTest._Benchmark _Benchmark_benchmark_11;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark _Benchmark_benchmark_14;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapKeySetTest._Benchmark _Benchmark_benchmark_16;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseTest._Benchmark _Benchmark_benchmark_17;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseKeySetTest._Benchmark _Benchmark_benchmark_19;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapValuesTest._Benchmark();
            _Benchmark_benchmark_11 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseValuesTest._Benchmark();
            _Benchmark_benchmark_14 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark();
            _Benchmark_benchmark_16 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapKeySetTest._Benchmark();
            _Benchmark_benchmark_17 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseTest._Benchmark();
            _Benchmark_benchmark_19 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseKeySetTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_14.makePayloads();
            this._Benchmark_benchmark_14.makePayloads();
            this._Benchmark_benchmark_16.makePayloads();
            this._Benchmark_benchmark_17.makePayloads();
            this._Benchmark_benchmark_17.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_14.makePayloads();
            this._Benchmark_benchmark_14.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_1036() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.detectWith);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.detectWithIfNone);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.detectWithOptional);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.detectOptional_value);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.detect_value);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.detectWithIfNone);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.detectWith);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.detectWithOptional);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.detectIfNone_value);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.getKeysAndGetValues);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.contains);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.contains);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.detectOptional);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.detect);
            this._Benchmark_benchmark_14.runBenchmark(this._Benchmark_benchmark_14.payloads.sumOfFloat);
            this._Benchmark_benchmark_14.runBenchmark(this._Benchmark_benchmark_14.payloads.sumOfDouble);
            this._Benchmark_benchmark_16.runBenchmark(this._Benchmark_benchmark_16.payloads.contains);
            this._Benchmark_benchmark_17.runBenchmark(this._Benchmark_benchmark_17.payloads.sumOfFloat);
            this._Benchmark_benchmark_17.runBenchmark(this._Benchmark_benchmark_17.payloads.sumOfDouble);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.contains);
            this._Benchmark_benchmark_14.runBenchmark(this._Benchmark_benchmark_14.payloads.clearKeySet);
            this._Benchmark_benchmark_14.runBenchmark(this._Benchmark_benchmark_14.payloads.clearEntrySet);
        }

   }

}