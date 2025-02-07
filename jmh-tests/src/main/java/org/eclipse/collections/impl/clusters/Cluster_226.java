package org.eclipse.collections.impl.clusters;

public class Cluster_226 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.immutable.ImmutableSubListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.immutable.ImmutableSeptupletonListTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark _Benchmark_benchmark_8;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagTest._Benchmark _Benchmark_benchmark_10;
       private org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_11;
       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_12;
       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplTest._Benchmark _Benchmark_benchmark_13;
       private org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark _Benchmark_benchmark_14;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.immutable.ImmutableSubListTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.immutable.ImmutableSeptupletonListTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.bag.sorted.mutable.UnmodifiableSortedBagTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.bag.sorted.mutable.SynchronizedSortedBagTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagTest._Benchmark();
            _Benchmark_benchmark_11 = new org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_12 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_13 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplTest._Benchmark();
            _Benchmark_benchmark_14 = new org.eclipse.collections.impl.bimap.mutable.HashBiMapTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_11.makePayloads();
            this._Benchmark_benchmark_12.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
            this._Benchmark_benchmark_14.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_226() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.flatCollect);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.containsAll);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.selectWith);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.tap);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.selectWith);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.tap);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.selectWith);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.rejectWith_target);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.forEachWith);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.rejectWith_target);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.tap);
            this._Benchmark_benchmark_11.runBenchmark(this._Benchmark_benchmark_11.payloads.tap);
            this._Benchmark_benchmark_12.runBenchmark(this._Benchmark_benchmark_12.payloads.collectBoolean);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.forEachWithIndex);
            this._Benchmark_benchmark_14.runBenchmark(this._Benchmark_benchmark_14.payloads.forEachWith);
        }

   }

}