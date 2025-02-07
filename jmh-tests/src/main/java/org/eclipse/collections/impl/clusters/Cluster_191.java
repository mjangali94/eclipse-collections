package org.eclipse.collections.impl.clusters;

public class Cluster_191 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsUnmodifiableTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.list.mutable.primitive.SynchronizedBooleanListTest._Benchmark _Benchmark_benchmark_15;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_16;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark();
            _Benchmark_benchmark_15 = new org.eclipse.collections.impl.list.mutable.primitive.SynchronizedBooleanListTest._Benchmark();
            _Benchmark_benchmark_16 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_15.makePayloads();
            this._Benchmark_benchmark_16.makePayloads();
            this._Benchmark_benchmark_16.makePayloads();
            this._Benchmark_benchmark_16.makePayloads();
            this._Benchmark_benchmark_16.makePayloads();
            this._Benchmark_benchmark_16.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_191() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.asSynchronized);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collectInt);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.maxByOptional);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.collectInt);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.asUnmodifiable);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.testToString);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.appendString);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.toReversed);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.makeStringWithSeparatorAndStartAndEnd);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.appendStringWithSeparatorAndStartAndEnd);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.set);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.appendStringWithSeparator);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.removeIndex);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.makeStringWithSeparator);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.makeString);
            this._Benchmark_benchmark_15.runBenchmark(this._Benchmark_benchmark_15.payloads.collect);
            this._Benchmark_benchmark_16.runBenchmark(this._Benchmark_benchmark_16.payloads.getFirst);
            this._Benchmark_benchmark_16.runBenchmark(this._Benchmark_benchmark_16.payloads.removeObject);
            this._Benchmark_benchmark_16.runBenchmark(this._Benchmark_benchmark_16.payloads.listIterator);
            this._Benchmark_benchmark_16.runBenchmark(this._Benchmark_benchmark_16.payloads.chunk_zero_throws);
            this._Benchmark_benchmark_16.runBenchmark(this._Benchmark_benchmark_16.payloads.iterator);
        }

   }

}