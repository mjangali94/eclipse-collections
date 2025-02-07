package org.eclipse.collections.impl.clusters;

public class Cluster_269 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.immutable.ImmutableEmptyListTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.list.mutable.ListAdapterAsUnmodifiableTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark _Benchmark_benchmark_10;
       private org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagTest._Benchmark _Benchmark_benchmark_15;
       private org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark _Benchmark_benchmark_17;
       private org.eclipse.collections.impl.list.immutable.ImmutableSextupletonListTest._Benchmark _Benchmark_benchmark_19;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_20;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.bag.sorted.mutable.TreeBagTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.list.immutable.ImmutableEmptyListTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.list.mutable.ListAdapterAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark();
            _Benchmark_benchmark_15 = new org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagTest._Benchmark();
            _Benchmark_benchmark_17 = new org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark();
            _Benchmark_benchmark_19 = new org.eclipse.collections.impl.list.immutable.ImmutableSextupletonListTest._Benchmark();
            _Benchmark_benchmark_20 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_15.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_17.makePayloads();
            this._Benchmark_benchmark_17.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_20.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_269() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.reject);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.select);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.toSortedListBy);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.min_empty_throws);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.collectIf);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.iterator_throws);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.selectWith_target);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.rejectWith_target);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.tap);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.collectWith);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.toSortedSet);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.select);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.reject);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectWith);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectIfWithTarget);
            this._Benchmark_benchmark_15.runBenchmark(this._Benchmark_benchmark_15.payloads.asLazy);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.fusedCollectMakeString);
            this._Benchmark_benchmark_17.runBenchmark(this._Benchmark_benchmark_17.payloads.select);
            this._Benchmark_benchmark_17.runBenchmark(this._Benchmark_benchmark_17.payloads.reject);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.collect);
            this._Benchmark_benchmark_20.runBenchmark(this._Benchmark_benchmark_20.payloads.iterator);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.containsAll);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.selectWithIndex);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.rejectWithIndex);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.appendString);
        }

   }

}