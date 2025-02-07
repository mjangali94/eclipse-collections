package org.eclipse.collections.impl.clusters;

public class Cluster_875 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark _Benchmark_benchmark_8;
       private org.eclipse.collections.impl.multimap.bag.sorted.mutable.SynchronizedSortedBagMultimapTest._Benchmark _Benchmark_benchmark_12;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapCustomLockTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark();
            _Benchmark_benchmark_12 = new org.eclipse.collections.impl.multimap.bag.sorted.mutable.SynchronizedSortedBagMultimapTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_12.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_875() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.withMapEmptyAndTargetEmpty);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.putAllMapIterableEmptyAndTargetEmpty);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.withMapIterableEmptyAndTargetEmpty);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.withMapIterableEmptyAndTargetEmpty);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.putAllMapIterableEmptyAndTargetEmpty);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.aggregateByNonMutating);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.toMap);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.testNewMap);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.testNewMap);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.injectIntoKeyValue);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.toMap);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.toMap);
            this._Benchmark_benchmark_12.runBenchmark(this._Benchmark_benchmark_12.payloads.keyBag);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.injectIntoKeyValue);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.injectIntoKeyValue);
        }

   }

}