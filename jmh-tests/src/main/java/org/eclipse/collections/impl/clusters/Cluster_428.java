package org.eclipse.collections.impl.clusters;

public class Cluster_428 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsUnmodifiableTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.list.mutable.FastListAsUnmodifiableTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark _Benchmark_benchmark_10;
       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_11;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsReadUntouchableTest._Benchmark _Benchmark_benchmark_13;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.list.mutable.FastListAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark();
            _Benchmark_benchmark_11 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_13 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsReadUntouchableTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_428() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.chunk_single);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.chunk);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.collect);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.chunk);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.chunk_single);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.chunk_single);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.chunk);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.collect);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.corresponds);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.collectWith);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.corresponds);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.chunk_single);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.chunk);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.collect);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.corresponds);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.flatCollect);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.flatCollectWith);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.collectWith);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.testNewWith);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.anySatisfyWith);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.allSatisfyWith);
        }

   }

}