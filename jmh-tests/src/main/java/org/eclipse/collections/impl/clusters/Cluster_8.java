package org.eclipse.collections.impl.clusters;

public class Cluster_8 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark _Benchmark_benchmark_3;
       private org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark _Benchmark_benchmark_13;
       private org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark _Benchmark_benchmark_23;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.mutable.FastListTest._Benchmark();
            _Benchmark_benchmark_3 = new org.eclipse.collections.impl.list.mutable.ListAdapterTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.list.mutable.ArrayListAdapterTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.list.fixed.ArrayAdapterTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListTest._Benchmark();
            _Benchmark_benchmark_13 = new org.eclipse.collections.impl.list.mutable.CompositeFastListTest._Benchmark();
            _Benchmark_benchmark_23 = new org.eclipse.collections.impl.list.immutable.ImmutableArrayListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_3.makePayloads();
            this._Benchmark_benchmark_23.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_8() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.wrapSet);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.toSet);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.addAllIterable);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.addAllIterable);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.addAllIterable);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.toSet);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.toSet);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.toSet);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.toSet);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.reduceOptional);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.addAllAtIndex);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.withoutAll);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.reduceOptional);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.addAllIterable);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.rejectWithIndexWithTarget);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.selectWithIndexWithTarget);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.rejectWithIndexWithTarget);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.selectWithIndexWithTarget);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.addAllAtIndex);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.testNewListWithIterable);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.withoutAll);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.constructorWithCollection);
            this._Benchmark_benchmark_3.runBenchmark(this._Benchmark_benchmark_3.payloads.toSet);
            this._Benchmark_benchmark_23.runBenchmark(this._Benchmark_benchmark_23.payloads.newListWithVarArgs);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.count);
        }

   }

}