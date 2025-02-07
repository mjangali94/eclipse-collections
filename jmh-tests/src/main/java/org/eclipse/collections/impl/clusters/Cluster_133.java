package org.eclipse.collections.impl.clusters;

public class Cluster_133 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark _Benchmark_benchmark_8;
       private org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayListTest._Benchmark _Benchmark_benchmark_15;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark();
            _Benchmark_benchmark_15 = new org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_15.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_133() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.withAll);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.minBy_null_throws);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.getOnly_empty_throws);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.getOnly_not_only_one_throws);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.with);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.binarySearch);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.without);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.removeObject);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.with);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.maxBy_null_throws);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.minBy_null_throws);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.getOnly);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.getOnly_not_only_one_throws);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.without);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.with);
            this._Benchmark_benchmark_15.runBenchmark(this._Benchmark_benchmark_15.payloads.collect);
        }

   }

}