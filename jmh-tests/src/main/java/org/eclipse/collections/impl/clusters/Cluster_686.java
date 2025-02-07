package org.eclipse.collections.impl.clusters;

public class Cluster_686 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.bag.immutable.ImmutableEmptyBagTest._Benchmark _Benchmark_benchmark_0;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.bag.immutable.ImmutableEmptyBagTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_686() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.max);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.anySatisfy);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.noneSatisfyWithOccurrences);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.add);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.noneSatisfyWith);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.min);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.minBy);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.toImmutable);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.newWithout);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.anySatisfyWith);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.allSatisfyWith);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.noneSatisfy);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.detectWithOccurrences);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.anySatisfyWithOccurrences);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.getFirst);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.min_without_comparator);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.allSatisfyWithOccurrences);
        }

   }

}