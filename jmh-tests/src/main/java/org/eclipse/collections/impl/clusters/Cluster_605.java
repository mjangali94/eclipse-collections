package org.eclipse.collections.impl.clusters;

public class Cluster_605 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_10;
       private org.eclipse.collections.impl.bag.immutable.ImmutableArrayBagTest._Benchmark _Benchmark_benchmark_11;
       private org.eclipse.collections.impl.bag.immutable.ImmutableHashBagTest._Benchmark _Benchmark_benchmark_14;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.immutable.ImmutableSingletonBagTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_11 = new org.eclipse.collections.impl.bag.immutable.ImmutableArrayBagTest._Benchmark();
            _Benchmark_benchmark_14 = new org.eclipse.collections.impl.bag.immutable.ImmutableHashBagTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_14.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_605() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.selectToTarget);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.rejectToTarget);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.count);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collect_target);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.injectIntoInt);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.notEmpty);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.injectIntoFloat);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.injectIntoLong);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.injectIntoDouble);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.selectWithToTarget);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.countByWith);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.asLazy);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.notEmpty);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.min_without_comparator);
            this._Benchmark_benchmark_14.runBenchmark(this._Benchmark_benchmark_14.payloads.contains);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.chunk_zero_throws);
        }

   }

}