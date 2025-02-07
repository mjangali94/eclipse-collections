package org.eclipse.collections.impl.clusters;

public class Cluster_1023 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapValuesTest._Benchmark _Benchmark_benchmark_8;
       private org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseValuesTest._Benchmark _Benchmark_benchmark_13;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapValuesTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.bimap.mutable.UnmodifiableBiMapTest._Benchmark();
            _Benchmark_benchmark_13 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapInverseValuesTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_1023() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.getIfAbsent);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.getIfAbsentWith);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.getIfAbsent);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.getOrDefault);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.getIfAbsentWith);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.getIfAbsentPutValue);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.getOrDefault);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.groupByUniqueKey);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.add);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.ifPresentApply);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.getIfAbsentPutValue);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.getIfAbsentPutWith);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.contains);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.add);
        }

   }

}