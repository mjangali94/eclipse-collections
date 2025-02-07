package org.eclipse.collections.impl.clusters;

public class Cluster_1060 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.UnmodifiableMapEntrySetTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.bimap.immutable.ImmutableHashBiMapTest._Benchmark _Benchmark_benchmark_8;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseValuesTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapKeySetTest._Benchmark _Benchmark_benchmark_10;
       private org.eclipse.collections.impl.bimap.immutable.ImmutableHashBiMapInverseTest._Benchmark _Benchmark_benchmark_11;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseKeySetTest._Benchmark _Benchmark_benchmark_12;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.UnmodifiableMapEntrySetTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.bimap.immutable.ImmutableHashBiMapTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseValuesTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapKeySetTest._Benchmark();
            _Benchmark_benchmark_11 = new org.eclipse.collections.impl.bimap.immutable.ImmutableHashBiMapInverseTest._Benchmark();
            _Benchmark_benchmark_12 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseKeySetTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
            this._Benchmark_benchmark_12.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_1060() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.groupByUniqueKey_target);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.testNewWithWithWith);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.testNewWithWith);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.groupByUniqueKey_throws);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.groupByUniqueKey);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.testMakeString);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.testAppendString);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.get);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.testNewEmpty);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.isEmpty);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.isEmpty);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.testNewEmpty);
            this._Benchmark_benchmark_12.runBenchmark(this._Benchmark_benchmark_12.payloads.isEmpty);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.isEmpty);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.notEmpty);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.putAllMapIterableEmpty);
        }

   }

}