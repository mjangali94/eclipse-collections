package org.eclipse.collections.impl.clusters;

public class Cluster_594 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark _Benchmark_benchmark_13;
       private org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark _Benchmark_benchmark_14;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_17;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsUnmodifiableTest._Benchmark _Benchmark_benchmark_22;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark _Benchmark_benchmark_23;
       private org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark _Benchmark_benchmark_26;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark();
            _Benchmark_benchmark_13 = new org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark();
            _Benchmark_benchmark_14 = new org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark();
            _Benchmark_benchmark_17 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            _Benchmark_benchmark_22 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_23 = new org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark();
            _Benchmark_benchmark_26 = new org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
            this._Benchmark_benchmark_14.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_17.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_17.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_22.makePayloads();
            this._Benchmark_benchmark_23.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_26.makePayloads();
            this._Benchmark_benchmark_26.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_594() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.sumLong);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.sumInteger);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.injectInto);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.toArray);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.appendString);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.toArray);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.injectInto);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.toArray);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.sortThis_with_null);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.makeString);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.appendString);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.testToString);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.containsAllIterable);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.injectInto);
            this._Benchmark_benchmark_14.runBenchmark(this._Benchmark_benchmark_14.payloads.toArray);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.injectInto);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.sumFloat);
            this._Benchmark_benchmark_17.runBenchmark(this._Benchmark_benchmark_17.payloads.toImmutableSortedList_with_comparator);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.sumDouble);
            this._Benchmark_benchmark_17.runBenchmark(this._Benchmark_benchmark_17.payloads.toImmutableSortedListBy);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.containsAll);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.newWith);
            this._Benchmark_benchmark_22.runBenchmark(this._Benchmark_benchmark_22.payloads.subListListIterator);
            this._Benchmark_benchmark_23.runBenchmark(this._Benchmark_benchmark_23.payloads.injectInto);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.makeString);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.testToString);
            this._Benchmark_benchmark_26.runBenchmark(this._Benchmark_benchmark_26.payloads.toSortedBag_with_null);
            this._Benchmark_benchmark_26.runBenchmark(this._Benchmark_benchmark_26.payloads.containsAllIterable);
        }

   }

}