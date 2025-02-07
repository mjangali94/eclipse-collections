package org.eclipse.collections.impl.clusters;

public class Cluster_114 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.immutable.ImmutableEmptyListTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark _Benchmark_benchmark_10;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.immutable.ImmutableEmptyListTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_114() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.asLazy);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.toImmutable);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.subListFromGreaterThanTO);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.chunk_empty);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.minByOptional);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.chunk_empty);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.forEachInBothThrowsOnNullList);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.forEachWithIndex);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.wrapList);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.toReversed);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.chunk_empty);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.forLoop);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.containsAllIterable);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.iteratorRemove);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.newEmpty);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.testClone);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.detectWith);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.containsAllArray);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.toSortedListWithNullWithNoComparator);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.toSortedListWithNullWithNoComparatorOnListWithMoreThan10Elements);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.toSortedList_with_null);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.testToString);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.detectLastIndex);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.detectIndex);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.toSortedList_natural_ordering);
        }

   }

}