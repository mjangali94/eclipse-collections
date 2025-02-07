package org.eclipse.collections.impl.clusters;

public class Cluster_677 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark _Benchmark_benchmark_10;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_677() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.select);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.reject);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.select);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.reject);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.select);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.reject);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.reject);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.reject);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.select);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.select);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.stream);
        }

   }

}