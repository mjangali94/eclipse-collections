package org.eclipse.collections.impl.clusters;

public class Cluster_648 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.bimap.immutable.ImmutableHashBiMapTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.bimap.immutable.ImmutableHashBiMapInverseTest._Benchmark _Benchmark_benchmark_7;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.bimap.immutable.ImmutableHashBiMapTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.bimap.immutable.ImmutableHashBiMapInverseTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_648() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.aggregateByMutating);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.aggregateByMutating);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.aggregateByMutating);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.aggregateByMutating);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.aggregateByMutating);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.groupByUniqueKey_target);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.get);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.get);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.withMapIterableEmptyAndTargetEmpty);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.putAllMapIterableEmptyAndTargetEmpty);
        }

   }

}