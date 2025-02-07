package org.eclipse.collections.impl.clusters;

public class Cluster_1061 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.UnmodifiableMapEntrySetTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapValuesTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseValuesTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark _Benchmark_benchmark_8;
       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark _Benchmark_benchmark_10;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.UnmodifiableMapEntrySetTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapValuesTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseValuesTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_1061() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.groupByUniqueKey_target);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.testNewMapWithKeyValue);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.equalsAndHashCode);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.groupByUniqueKey_target);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.sumOfInt);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.sumOfLong);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.clear);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.clear);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.groupByUniqueKey_target);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.groupByUniqueKey_target);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.maxBy);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.minBy);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.makeString);
        }

   }

}