package org.eclipse.collections.impl.clusters;

public class Cluster_331 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.immutable.ImmutableArrayBagTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.immutable.ImmutableEmptyBagTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.immutable.ImmutableSubListTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark _Benchmark_benchmark_10;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.immutable.ImmutableArrayBagTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.bag.immutable.ImmutableEmptyBagTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.list.immutable.ImmutableSubListTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_331() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.reduceOptional);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.reduceOptional);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.collectWithIndex);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.collectWithIndex);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.injectIntoWith);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.max_null_throws);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.min_null_throws);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.minBy_null_throws);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.maxBy_null_throws);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.collectWithIndex);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.forEachWithIndex);
        }

   }

}