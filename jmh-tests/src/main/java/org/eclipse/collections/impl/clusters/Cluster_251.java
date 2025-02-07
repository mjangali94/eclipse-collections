package org.eclipse.collections.impl.clusters;

public class Cluster_251 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.mutable.FastListAsUnmodifiableTest._Benchmark _Benchmark_benchmark_8;
       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark _Benchmark_benchmark_11;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.list.mutable.FastListAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_11 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_251() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.without);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.getOnly_empty_throws);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.getOnly_not_only_one_throws);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.getWithArrayIndexOutOfBoundsException);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.sortThisWithNullWithNoComparator);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.sortThisWithNullWithNoComparatorOnListWithMoreThan10Elements);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.getWithIndexOutOfBoundsException);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.outOfBoundsCondition);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.detectLastIndex);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.sumLong);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.detectIndex);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.testEquals);
        }

   }

}