package org.eclipse.collections.impl.clusters;

public class Cluster_135 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.mutable.FastListAsUnmodifiableTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.fixed.SingletonListSubListTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.mutable.ListAdapterAsUnmodifiableTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterAsUnmodifiableTest._Benchmark _Benchmark_benchmark_9;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.mutable.FastListAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.fixed.SingletonListSubListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.list.mutable.ListAdapterAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterAsUnmodifiableTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_135() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.rejectWithIndexWithTarget);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.selectWithIndexWithTarget);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.distinctView);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.zipWithIndex);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.zipWithIndex);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.zipWithIndex);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.zipWithIndex);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.zipWithIndex);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.testSize);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.zipWithIndex);
        }

   }

}