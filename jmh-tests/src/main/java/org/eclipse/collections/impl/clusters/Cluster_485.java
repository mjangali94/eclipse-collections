package org.eclipse.collections.impl.clusters;

public class Cluster_485 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsUnmodifiableTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsReadUntouchableTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.mutable.ListAdapterAsUnmodifiableTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.fixed.SingletonListSubListTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.list.mutable.ArrayListAdapterAsUnmodifiableTest._Benchmark _Benchmark_benchmark_11;
       private org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark _Benchmark_benchmark_13;
       private org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark _Benchmark_benchmark_15;
       private org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark _Benchmark_benchmark_17;
       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_18;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark _Benchmark_benchmark_23;
       private org.eclipse.collections.impl.list.immutable.ImmutableSubListTest._Benchmark _Benchmark_benchmark_24;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsReadUntouchableTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.mutable.ListAdapterAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.list.fixed.SingletonListSubListTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark();
            _Benchmark_benchmark_11 = new org.eclipse.collections.impl.list.mutable.ArrayListAdapterAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_13 = new org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark();
            _Benchmark_benchmark_15 = new org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark();
            _Benchmark_benchmark_17 = new org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark();
            _Benchmark_benchmark_18 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_23 = new org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark();
            _Benchmark_benchmark_24 = new org.eclipse.collections.impl.list.immutable.ImmutableSubListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
            this._Benchmark_benchmark_15.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_17.makePayloads();
            this._Benchmark_benchmark_18.makePayloads();
            this._Benchmark_benchmark_18.makePayloads();
            this._Benchmark_benchmark_18.makePayloads();
            this._Benchmark_benchmark_18.makePayloads();
            this._Benchmark_benchmark_18.makePayloads();
            this._Benchmark_benchmark_23.makePayloads();
            this._Benchmark_benchmark_24.makePayloads();
            this._Benchmark_benchmark_15.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_18.makePayloads();
            this._Benchmark_benchmark_18.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_485() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.partition);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.partition);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.partition);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.partition);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.partitionWith);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.partition);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.partitionWith);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.partitionWith);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.partition);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.partitionWith);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.partitionWith);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.partitionWith);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.partition);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.reverseForEach);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.reverseForEachWithIndex);
            this._Benchmark_benchmark_15.runBenchmark(this._Benchmark_benchmark_15.payloads.asReversed);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.newEmpty);
            this._Benchmark_benchmark_17.runBenchmark(this._Benchmark_benchmark_17.payloads.asReversed);
            this._Benchmark_benchmark_18.runBenchmark(this._Benchmark_benchmark_18.payloads.makeStringWithSeparator);
            this._Benchmark_benchmark_18.runBenchmark(this._Benchmark_benchmark_18.payloads.containsAllArray);
            this._Benchmark_benchmark_18.runBenchmark(this._Benchmark_benchmark_18.payloads.makeStringWithSeparatorAndStartAndEnd);
            this._Benchmark_benchmark_18.runBenchmark(this._Benchmark_benchmark_18.payloads.appendStringWithSeparatorAndStartAndEnd);
            this._Benchmark_benchmark_18.runBenchmark(this._Benchmark_benchmark_18.payloads.makeString);
            this._Benchmark_benchmark_23.runBenchmark(this._Benchmark_benchmark_23.payloads.asReversed);
            this._Benchmark_benchmark_24.runBenchmark(this._Benchmark_benchmark_24.payloads.forEach);
            this._Benchmark_benchmark_15.runBenchmark(this._Benchmark_benchmark_15.payloads.partition);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.chunk_large_size);
            this._Benchmark_benchmark_18.runBenchmark(this._Benchmark_benchmark_18.payloads.toArray);
            this._Benchmark_benchmark_18.runBenchmark(this._Benchmark_benchmark_18.payloads.testToString);
        }

   }

}