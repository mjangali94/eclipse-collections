package org.eclipse.collections.impl.clusters;

public class Cluster_678 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.immutable.ImmutableSeptupletonListTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.list.immutable.ImmutableSubListTest._Benchmark _Benchmark_benchmark_10;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_11;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.list.immutable.ImmutableSeptupletonListTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.list.immutable.ImmutableSubListTest._Benchmark();
            _Benchmark_benchmark_11 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_678() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.forEachOnRange);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.forEachWithIndexOnRange);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.sumDouble);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.sumFloat);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.forEachWith);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.forEachInBothUsingListIterate);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.minOptional);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.each);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.maxOptional);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.forEachWith);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.selectInstancesOf);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.take);
        }

   }

}