package org.eclipse.collections.impl.clusters;

public class Cluster_118 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.fixed.SingletonListSubListTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.immutable.ImmutableSubListTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark _Benchmark_benchmark_10;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.fixed.SingletonListSubListTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.list.immutable.ImmutableSubListTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_118() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.flatCollectWith);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collectBoolean);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collectFloat);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collectDouble);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collectChar);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collectByte);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collectShort);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.addAll);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.toImmutable);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.get);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.indexOf);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.take_throws);
        }

   }

}