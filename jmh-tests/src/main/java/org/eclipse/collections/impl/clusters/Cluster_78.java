package org.eclipse.collections.impl.clusters;

public class Cluster_78 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.map.mutable.primitive.CharBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.map.mutable.primitive.ShortBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.map.mutable.primitive.IntBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.map.mutable.primitive.FloatBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.map.mutable.primitive.DoubleBooleanHashMapValuesTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.map.mutable.primitive.UnmodifiableByteBooleanMapValuesTest._Benchmark _Benchmark_benchmark_6;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.map.mutable.primitive.CharBooleanHashMapValuesTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.map.mutable.primitive.ShortBooleanHashMapValuesTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.map.mutable.primitive.IntBooleanHashMapValuesTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.map.mutable.primitive.FloatBooleanHashMapValuesTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.map.mutable.primitive.DoubleBooleanHashMapValuesTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.map.mutable.primitive.UnmodifiableByteBooleanMapValuesTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_78() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.removeOccurrences);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collect);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.collect);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.collect);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.collect);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.collect);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.collect);
        }

   }

}