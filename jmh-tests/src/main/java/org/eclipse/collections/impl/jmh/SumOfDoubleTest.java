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

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.collections.api.list.MutableList;

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
public class SumOfDoubleTest 
{
    private static final int SIZE = 3_000_000;
    private static final int BATCH_SIZE = 10_000;
    private static final Stream<Double> DOUBLES = new Random().doubles(1.0d, 100.0d).boxed();

    private final List<Double> doublesJDK = DOUBLES.limit(SIZE).collect(Collectors.toList());
    private final MutableList<Double> doublesEC = FastList.newListWith(this.doublesJDK.toArray(new Double[SIZE]));

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
    }

    @TearDown
    public void tearDown() throws InterruptedException
    {
        this.executorService.shutdownNow();
        this.executorService.awaitTermination(1L, TimeUnit.SECONDS);
    }

    @Benchmark @OperationsPerInvocation(1) 
    public double serial_lazy_collectDoubleSum_jdk()
    {
        return this.doublesJDK.stream().mapToDouble(each -> each).sum();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public double serial_lazy_collectDoubleSum_streams_ec()
    {
        return this.doublesEC.stream().mapToDouble(each -> each).sum();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public double parallel_lazy_collectDoubleSum_jdk()
    {
        return this.doublesJDK.parallelStream().mapToDouble(each -> each).sum();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public double parallel_lazy_collectDoubleSum_streams_ec()
    {
        return this.doublesEC.parallelStream().mapToDouble(each -> each).sum();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public double serial_eager_directSumOfDouble_ec()
    {
        return this.doublesEC.sumOfDouble(each -> each);
    }

    @Benchmark @OperationsPerInvocation(1) 
    public double serial_eager_collectDoubleSum_ec()
    {
        return this.doublesEC.collectDouble(each -> each).sum();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public double serial_lazy_collectDoubleSum_ec()
    {
        return this.doublesEC.asLazy().collectDouble(each -> each).sum();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public double parallel_lazy_directSumOfDouble_ec()
    {
        return this.doublesEC.asParallel(this.executorService, BATCH_SIZE).sumOfDouble(Double::doubleValue);
    }

    @Benchmark @OperationsPerInvocation(1) 
    public double serial_lazy_directSumOfDouble_ec()
    {
        return this.doublesEC.asLazy().sumOfDouble(each -> each);
    }
}
