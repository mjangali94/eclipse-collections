package org.eclipse.collections.impl.clusters;

public class Cluster_173 {

   @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

       private org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark _Benchmark_benchmark_0;
       private org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark _Benchmark_benchmark_1;
       private org.eclipse.collections.impl.list.immutable.ImmutableSextupletonListTest._Benchmark _Benchmark_benchmark_2;
       private org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark _Benchmark_benchmark_6;
       private org.eclipse.collections.impl.list.immutable.ImmutableSeptupletonListTest._Benchmark _Benchmark_benchmark_7;
       private org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark _Benchmark_benchmark_10;
       private org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark _Benchmark_benchmark_13;
       private org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark _Benchmark_benchmark_19;
       private org.eclipse.collections.impl.list.mutable.ArrayListAdapterAsUnmodifiableTest._Benchmark _Benchmark_benchmark_21;
       private org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsReadUntouchableTest._Benchmark _Benchmark_benchmark_22;
       private org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark _Benchmark_benchmark_27;
       private org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark _Benchmark_benchmark_32;

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            _Benchmark_benchmark_0 = new org.eclipse.collections.impl.list.immutable.ImmutableQuintupletonListTest._Benchmark();
            _Benchmark_benchmark_1 = new org.eclipse.collections.impl.list.immutable.ImmutableTripletonListTest._Benchmark();
            _Benchmark_benchmark_2 = new org.eclipse.collections.impl.list.immutable.ImmutableSextupletonListTest._Benchmark();
            _Benchmark_benchmark_6 = new org.eclipse.collections.impl.list.immutable.ImmutableQuadrupletonListTest._Benchmark();
            _Benchmark_benchmark_7 = new org.eclipse.collections.impl.list.immutable.ImmutableSeptupletonListTest._Benchmark();
            _Benchmark_benchmark_10 = new org.eclipse.collections.impl.bag.sorted.immutable.ImmutableEmptySortedBagTest._Benchmark();
            _Benchmark_benchmark_13 = new org.eclipse.collections.impl.list.immutable.ImmutableOctupletonListTest._Benchmark();
            _Benchmark_benchmark_19 = new org.eclipse.collections.impl.list.immutable.ImmutableNonupletonListTest._Benchmark();
            _Benchmark_benchmark_21 = new org.eclipse.collections.impl.list.mutable.ArrayListAdapterAsUnmodifiableTest._Benchmark();
            _Benchmark_benchmark_22 = new org.eclipse.collections.impl.bag.mutable.MultiReaderHashBagAsReadUntouchableTest._Benchmark();
            _Benchmark_benchmark_27 = new org.eclipse.collections.impl.list.mutable.MultiReaderFastListAsWriteUntouchableTest._Benchmark();
            _Benchmark_benchmark_32 = new org.eclipse.collections.impl.list.immutable.ImmutableDecapletonListTest._Benchmark();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_1.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_6.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
            this._Benchmark_benchmark_0.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
            this._Benchmark_benchmark_2.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_21.makePayloads();
            this._Benchmark_benchmark_22.makePayloads();
            this._Benchmark_benchmark_22.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_19.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_27.makePayloads();
            this._Benchmark_benchmark_27.makePayloads();
            this._Benchmark_benchmark_27.makePayloads();
            this._Benchmark_benchmark_10.makePayloads();
            this._Benchmark_benchmark_7.makePayloads();
            this._Benchmark_benchmark_32.makePayloads();
            this._Benchmark_benchmark_32.makePayloads();
            this._Benchmark_benchmark_32.makePayloads();
            this._Benchmark_benchmark_13.makePayloads();
        }
        
        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_Cluster_173() throws java.lang.Throwable {
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.detect);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.detectIfNone);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.allSatisfy);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.noneSatisfy);
            this._Benchmark_benchmark_1.runBenchmark(this._Benchmark_benchmark_1.payloads.detectWithIfNone);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.detect);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.detectIfNone);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.noneSatisfy);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.allSatisfy);
            this._Benchmark_benchmark_6.runBenchmark(this._Benchmark_benchmark_6.payloads.detectWithIfNone);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.noneSatisfy);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.detectIfNone);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.detect);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.allSatisfy);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.noneSatisfy);
            this._Benchmark_benchmark_0.runBenchmark(this._Benchmark_benchmark_0.payloads.detectWithIfNone);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.detectIfNone);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.detect);
            this._Benchmark_benchmark_2.runBenchmark(this._Benchmark_benchmark_2.payloads.detectWithIfNone);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.allSatisfy);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.noneSatisfy);
            this._Benchmark_benchmark_21.runBenchmark(this._Benchmark_benchmark_21.payloads.flatCollect);
            this._Benchmark_benchmark_22.runBenchmark(this._Benchmark_benchmark_22.payloads.partitionWith);
            this._Benchmark_benchmark_22.runBenchmark(this._Benchmark_benchmark_22.payloads.partition);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.detectIfNone);
            this._Benchmark_benchmark_19.runBenchmark(this._Benchmark_benchmark_19.payloads.detect);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.detectIfNone);
            this._Benchmark_benchmark_27.runBenchmark(this._Benchmark_benchmark_27.payloads.collectShort);
            this._Benchmark_benchmark_27.runBenchmark(this._Benchmark_benchmark_27.payloads.collectFloat);
            this._Benchmark_benchmark_27.runBenchmark(this._Benchmark_benchmark_27.payloads.collectChar);
            this._Benchmark_benchmark_10.runBenchmark(this._Benchmark_benchmark_10.payloads.detectWithIfNone);
            this._Benchmark_benchmark_7.runBenchmark(this._Benchmark_benchmark_7.payloads.detectWithIfNone);
            this._Benchmark_benchmark_32.runBenchmark(this._Benchmark_benchmark_32.payloads.allSatisfy);
            this._Benchmark_benchmark_32.runBenchmark(this._Benchmark_benchmark_32.payloads.noneSatisfy);
            this._Benchmark_benchmark_32.runBenchmark(this._Benchmark_benchmark_32.payloads.detect);
            this._Benchmark_benchmark_13.runBenchmark(this._Benchmark_benchmark_13.payloads.detectIfNone);
        }

   }

}