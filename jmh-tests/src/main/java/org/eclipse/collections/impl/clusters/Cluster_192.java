package org.eclipse.collections.impl.clusters;

public class Cluster_192 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bimap.immutable.ImmutableHashBiMapTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.bimap.immutable.ImmutableHashBiMapInverseTest._Benchmark _Benchmark_benchmark_6;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bimap.immutable.ImmutableHashBiMapTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.bimap.immutable.ImmutableHashBiMapInverseTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_192() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.zipWithIndex);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.forEachKeyValue);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.forEachValue);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.forEach);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.zipWithIndex);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.addAllIterable);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.forEachValue);
        }

   }

}