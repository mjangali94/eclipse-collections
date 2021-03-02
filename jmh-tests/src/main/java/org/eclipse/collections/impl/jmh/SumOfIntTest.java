/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.jmh;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.IntList;

import org.eclipse.collections.impl.list.mutable.FastList;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import java.io.FileWriter;
import java.io.IOException;
import org.eclipse.collections.impl.myBlackhole;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class SumOfIntTest 
{
    private static final int SIZE = 3_000_000;
    private static final int BATCH_SIZE = 10_000;
    private static final Stream<Integer> INTEGERS = new Random().ints(0, 10_000).boxed();

    private final List<Integer> integersJDK = INTEGERS.limit(SIZE).collect(Collectors.toList());
    private final MutableList<Integer> integersEC = FastList.newListWith(this.integersJDK.toArray(new Integer[SIZE]));
    private final IntList intList = this.integersEC.collectInt(Integer::intValue);

    private ExecutorService executorService;

    	@TearDown(Level.Trial)
	public void nameLogger() throws InterruptedException {
		FileWriter fw=null;
		try {
			fw = new FileWriter("tmp2.csv", true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fw.write(this.getClass().getName() + "." + ","
					+ myBlackhole.hitting_count() + "\n");
		} catch (Exception e) {
		}
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Setup
    public void setUp()
    {
        this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Collections.shuffle(this.integersJDK);
        Collections.shuffle(this.integersEC);
    }

    @TearDown
    public void tearDown() throws InterruptedException
    {
        this.executorService.shutdownNow();
        this.executorService.awaitTermination(1L, TimeUnit.SECONDS);
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int serial_lazy_mapToIntSum_jdk()
    {
        return this.integersJDK.stream().mapToInt(Integer::intValue).sum();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int serial_lazy_mapToIntSum_streams_ec()
    {
        return this.integersEC.stream().mapToInt(Integer::intValue).sum();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public long serial_lazy_mapToLongSum_jdk()
    {
        return this.integersJDK.stream().mapToLong(Integer::longValue).sum();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public long serial_lazy_mapToLongSum_streams_ec()
    {
        return this.integersEC.stream().mapToLong(Integer::longValue).sum();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int parallel_lazy_mapToIntSum_jdk()
    {
        return this.integersJDK.parallelStream().mapToInt(Integer::intValue).sum();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int parallel_lazy_mapToIntSum_streams_ec()
    {
        return this.integersEC.parallelStream().mapToInt(Integer::intValue).sum();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public long parallel_lazy_mapToLongSum_jdk()
    {
        return this.integersJDK.parallelStream().mapToLong(Integer::longValue).sum();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public long parallel_lazy_mapToLongSum_streams_ec()
    {
        return this.integersEC.parallelStream().mapToLong(Integer::longValue).sum();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public long serial_eager_directSumOfInt_ec()
    {
        return this.integersEC.sumOfInt(Integer::intValue);
    }

    @Benchmark @OperationsPerInvocation(1) 
    public long serial_eager_collectIntSum_ec()
    {
        return this.integersEC.collectInt(Integer::intValue).sum();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public long serial_lazy_collectIntSum_ec()
    {
        return this.integersEC.asLazy().collectInt(Integer::intValue).sum();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public long parallel_lazy_sumOfInt_ec()
    {
        return this.integersEC.asParallel(this.executorService, BATCH_SIZE).sumOfInt(Integer::intValue);
    }

    @Benchmark @OperationsPerInvocation(1) 
    public long serial_lazy_sumOfInt_ec()
    {
        return this.integersEC.asLazy().sumOfInt(Integer::intValue);
    }

    @Benchmark @OperationsPerInvocation(1) 
    public long serial_eager_sum_intList()
    {
        return this.intList.sum();
    }
}
