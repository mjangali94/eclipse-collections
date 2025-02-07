package org.eclipse.collections.impl.clusters;

public class Cluster_10 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark _Benchmark_benchmark_8;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark _Benchmark_benchmark_10;
       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark _Benchmark_benchmark_15;
       private org.eclipse.collections.impl.list.immutable.ImmutableEmptyListTest._Benchmark _Benchmark_benchmark_19;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_8 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark();
            _Benchmark_benchmark_15 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark();
            _Benchmark_benchmark_19 = new org.eclipse.collections.impl.list.immutable.ImmutableEmptyListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_15.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_8.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_15.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_10() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.newEmpty);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.asLazy);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.asLazy);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.toImmutable);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.reverseForEachWithIndex_emptyList);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.reverseForEachWithIndex_emptyList);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.reverseForEachWithIndex_emptyList);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.reverseForEachWithIndex_emptyList);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.reverseForEachWithIndex_emptyList);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.reverseForEachWithIndex_emptyList);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.reverseForEachWithIndex_emptyList);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.asLazy);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.toImmutable);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.toImmutable);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.newEmpty);
            this._Benchmark_benchmark_15.runBenchmark(this._Benchmark_benchmark_15.payloads.asLazy);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.asLazy);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.asLazy);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.toImmutable);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.collectIf);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.collect);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.iterator);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.binarySearch);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.collectIfWithTarget);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.toImmutable);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.newEmpty);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.reverseForEach_emptyList);
            this._Benchmark_benchmark_8.runBenchmark(this._Benchmark_benchmark_8.payloads.reverseForEach_emptyList);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.reverseForEach_emptyList);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.reverseForEach_emptyList);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.reverseForEach_emptyList);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.reverseForEach_emptyList);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.reverseForEach_emptyList);
            this._Benchmark_benchmark_15.runBenchmark(this._Benchmark_benchmark_15.payloads.toSortedListBy_with_null);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.binarySearchWithComparator);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.noneSatisfyWith);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.countWith);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.clear);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.getFirst);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.min_without_comparator);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.allSatisfy);
        }

   }

}