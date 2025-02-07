package org.eclipse.collections.impl.clusters;

public class Cluster_821 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsReadUntouchableTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterAsUnmodifiableTest._Benchmark _Benchmark_benchmark_10;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_12;
       private org.eclipse.collections.impl.list.immutable.ImmutableSextupletonListTest._Benchmark _Benchmark_benchmark_13;
       private org.eclipse.collections.impl.list.immutable.ImmutableSeptupletonListTest._Benchmark _Benchmark_benchmark_15;
       private org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark _Benchmark_benchmark_16;
       private org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark _Benchmark_benchmark_19;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsUnmodifiableTest._Benchmark _Benchmark_benchmark_20;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsReadUntouchableTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_12 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_13 = new org.eclipse.collections.impl.list.immutable.ImmutableSextupletonListTest._Benchmark();
            _Benchmark_benchmark_15 = new org.eclipse.collections.impl.list.immutable.ImmutableSeptupletonListTest._Benchmark();
            _Benchmark_benchmark_16 = new org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark();
            _Benchmark_benchmark_19 = new org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark();
            _Benchmark_benchmark_20 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsUnmodifiableTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_12.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_15.makePayloads();
            this._Benchmark_benchmark_16.makePayloads();
            this._Benchmark_benchmark_16.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_20.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_821() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.testEquals);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.testClone);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.forEachInBoth);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.toList);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.newWithOut);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.select);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.selectWith);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.rejectWith);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.reject);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.toList);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.partitionWith);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.partition);
            this._Benchmark_benchmark_12.runBenchmark(this._Benchmark_benchmark_12.payloads.testClone);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.toList);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.reverseForEachWithIndex);
            this._Benchmark_benchmark_15.runBenchmark(this._Benchmark_benchmark_15.payloads.toList);
            this._Benchmark_benchmark_16.runBenchmark(this._Benchmark_benchmark_16.payloads.distinctWithHashingStrategy);
            this._Benchmark_benchmark_16.runBenchmark(this._Benchmark_benchmark_16.payloads.distinctBy);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.reverseForEachWithIndex);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.toList);
            this._Benchmark_benchmark_20.runBenchmark(this._Benchmark_benchmark_20.payloads.collectIf);
        }

   }

}