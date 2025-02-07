package org.eclipse.collections.impl.clusters;

public class Cluster_761 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark _Benchmark_benchmark_12;
       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplNoIteratorTest._Benchmark _Benchmark_benchmark_13;
       private org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark _Benchmark_benchmark_14;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark _Benchmark_benchmark_17;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark();
            _Benchmark_benchmark_12 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark();
            _Benchmark_benchmark_13 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableSortedBagImplNoIteratorTest._Benchmark();
            _Benchmark_benchmark_14 = new org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark();
            _Benchmark_benchmark_17 = new org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_12.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
            this._Benchmark_benchmark_14.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_17.makePayloads();
            this._Benchmark_benchmark_17.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_12.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_17.makePayloads();
            this._Benchmark_benchmark_17.makePayloads();
            this._Benchmark_benchmark_17.makePayloads();
            this._Benchmark_benchmark_17.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_761() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.iterator);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.injectIntoLong);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.toSortedSet);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.sumFloat);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.sumLong);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.sumInteger);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.sumDouble);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.detectWithIfNoneBlock);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.injectIntoInt);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.injectIntoDouble);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.injectIntoFloat);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.injectIntoLong);
            this._Benchmark_benchmark_12.runBenchmark(this._Benchmark_benchmark_12.payloads.collectBoolean_target);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.toSortedSet);
            this._Benchmark_benchmark_14.runBenchmark(this._Benchmark_benchmark_14.payloads.collectBoolean);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.selectWith);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.toSortedSetWithComparator);
            this._Benchmark_benchmark_17.runBenchmark(this._Benchmark_benchmark_17.payloads.sumInteger);
            this._Benchmark_benchmark_17.runBenchmark(this._Benchmark_benchmark_17.payloads.sumLong);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.sumDouble);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.sumFloat);
            this._Benchmark_benchmark_12.runBenchmark(this._Benchmark_benchmark_12.payloads.collectBoolean);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.detectIfNone);
            this._Benchmark_benchmark_17.runBenchmark(this._Benchmark_benchmark_17.payloads.injectIntoFloat);
            this._Benchmark_benchmark_17.runBenchmark(this._Benchmark_benchmark_17.payloads.injectIntoInt);
            this._Benchmark_benchmark_17.runBenchmark(this._Benchmark_benchmark_17.payloads.injectIntoLong);
            this._Benchmark_benchmark_17.runBenchmark(this._Benchmark_benchmark_17.payloads.injectIntoDouble);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.detectWithIfNone);
        }

   }

}