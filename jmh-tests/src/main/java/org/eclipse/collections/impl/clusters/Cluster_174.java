package org.eclipse.collections.impl.clusters;

public class Cluster_174 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark _Benchmark_benchmark_9;
       private org.eclipse.collections.impl.list.mutable.primitive.UnmodifiableBooleanListTest._Benchmark _Benchmark_benchmark_20;
       private org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark _Benchmark_benchmark_21;
       private org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark _Benchmark_benchmark_27;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark();
            _Benchmark_benchmark_9 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark();
            _Benchmark_benchmark_20 = new org.eclipse.collections.impl.list.mutable.primitive.UnmodifiableBooleanListTest._Benchmark();
            _Benchmark_benchmark_21 = new org.eclipse.collections.impl.list.immutable.ImmutableSingletonListTest._Benchmark();
            _Benchmark_benchmark_27 = new org.eclipse.collections.impl.list.immutable.ImmutableDoubletonListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_20.makePayloads();
            this._Benchmark_benchmark_21.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_9.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_27.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_174() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.collectIf);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.collectIf);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.removeIndex);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.getWithArrayIndexOutOfBoundsException);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.testAddAllAtIndexEmpty);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.clear);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.noneSatisfy);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.anySatisfy);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.allSatisfy);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.minByOptional);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.newListWithSize);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.getFirstOptional);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.getAny);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.distinct);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.rejectWith);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.maxBy);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.injectIntoWith);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.asUnmodifiable);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.detectIfNone);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.minBy);
            this._Benchmark_benchmark_20.runBenchmark(this._Benchmark_benchmark_20.payloads.collect);
            this._Benchmark_benchmark_21.runBenchmark(this._Benchmark_benchmark_21.payloads.distinct);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.minByOptional);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.min_null_throws);
            this._Benchmark_benchmark_9.runBenchmark(this._Benchmark_benchmark_9.payloads.maxByOptional);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.max_null_throws);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.distinct);
            this._Benchmark_benchmark_27.runBenchmark(this._Benchmark_benchmark_27.payloads.distinct);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.reject);
        }

   }

}