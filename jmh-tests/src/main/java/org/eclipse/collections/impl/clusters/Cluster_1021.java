package org.eclipse.collections.impl.clusters;

public class Cluster_1021 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.fixed.SingletonListSubListTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark _Benchmark_benchmark_10;
       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark _Benchmark_benchmark_13;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.fixed.SingletonListSubListTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark();
            _Benchmark_benchmark_13 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_1021() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.flatCollect);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.flatCollectWithTarget);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.flatCollectWith);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.testAppendString);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.flatCollectWith);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.flatCollect);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.flatCollectWithTarget);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.flatCollectWithTarget);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.flatCollectWith);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.flatCollect);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.flatCollectWithTarget);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.flatCollectWith);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.flatCollect);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.selectByOccurrences);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.retainAll);
        }

   }

}