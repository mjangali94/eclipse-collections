package org.eclipse.collections.impl.clusters;

public class Cluster_783 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsUnmodifiableTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark _Benchmark_benchmark_4;
       private org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagTest._Benchmark _Benchmark_benchmark_5;
       private org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.bag.immutable.ImmutableArrayBagTest._Benchmark _Benchmark_benchmark_7;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.bag.strategy.mutable.HashBagWithHashingStrategyTest._Benchmark();
            _Benchmark_benchmark_4 = new org.eclipse.collections.impl.bag.mutable.HashBagTest._Benchmark();
            _Benchmark_benchmark_5 = new org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.collection.mutable.CollectionAdapterTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.bag.immutable.ImmutableArrayBagTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_4.makePayloads();
            this._Benchmark_benchmark_5.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_783() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.partition);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.partitionWith);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.countByWith);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.countBy);
            this._Benchmark_benchmark_4.runBenchmark(this._Benchmark_benchmark_4.payloads.collectBooleanWithTarget);
            this._Benchmark_benchmark_5.runBenchmark(this._Benchmark_benchmark_5.payloads.collectBoolean);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.removeAll);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.forEachWithIndex);
        }

   }

}