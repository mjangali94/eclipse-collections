package org.eclipse.collections.impl.clusters;

public class Cluster_365 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.immutable.ImmutableSextupletonListTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark _Benchmark_benchmark_6;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.immutable.ImmutableSextupletonListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_365() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.subListToGreaterThanSize);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.detectIndex);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.subListFromGreaterThanTO);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.subListFromGreaterThanTO);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.iteratorRemove);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.forLoop);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.minBy);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.min);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.min_without_comparator);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.containsAllArray);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.max_without_comparator);
        }

   }

}