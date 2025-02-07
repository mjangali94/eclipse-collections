package org.eclipse.collections.impl.clusters;

public class Cluster_421 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsUnmodifiableTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.mutable.FastListAsUnmodifiableTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark _Benchmark_benchmark_11;
       private org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark _Benchmark_benchmark_12;
       private org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark _Benchmark_benchmark_14;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.mutable.FastListAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            _Benchmark_benchmark_11 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark();
            _Benchmark_benchmark_12 = new org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark();
            _Benchmark_benchmark_14 = new org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
            this._Benchmark_benchmark_12.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
            this._Benchmark_benchmark_14.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_421() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.rejectWithIndex);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectIf);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.selectWithIndex);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.select);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.partition);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.partitionWith);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.withMethods);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.forEachWithIndexOnRange);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.tap);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.reverseForEachWithIndex);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.tap);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.tap);
            this._Benchmark_benchmark_12.runBenchmark(this._Benchmark_benchmark_12.payloads.selectWith);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.selectAndRejectWith);
            this._Benchmark_benchmark_14.runBenchmark(this._Benchmark_benchmark_14.payloads.toArray);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.toReversed);
        }

   }

}