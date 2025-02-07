package org.eclipse.collections.impl.clusters;

public class Cluster_890 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.map.mutable.primitive.CharBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.map.mutable.primitive.ShortBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsReadUntouchableTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.map.mutable.primitive.FloatBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.map.mutable.primitive.SynchronizedIntBooleanMapValuesTest._Benchmark _Benchmark_benchmark_8;
       private org.eclipse.collections.impl.map.mutable.primitive.IntBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_9;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bimap.mutable.SynchronizedBiMapTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.map.mutable.primitive.CharBooleanHashMapValuesTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.map.mutable.primitive.ShortBooleanHashMapValuesTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsReadUntouchableTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.map.mutable.primitive.FloatBooleanHashMapValuesTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.map.mutable.primitive.SynchronizedIntBooleanMapValuesTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.map.mutable.primitive.IntBooleanHashMapValuesTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_890() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.flatten_value);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.injectInto);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.injectInto);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.containsNoneArray);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.containsNoneArray);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.collectChar);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.containsNoneArray);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.injectInto);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.addAllArray);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.containsAllArray);
        }

   }

}