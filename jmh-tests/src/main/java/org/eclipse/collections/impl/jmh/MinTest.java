/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.jmh;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.collections.api.list.MutableList;

import org.eclipse.collections.impl.list.Interval;
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
public class MinTest 
{
    private static final int SIZE = 3_000_000;
    private static final int BATCH_SIZE = 10_000;

    private final List<Integer> integersJDK = new ArrayList<>(Interval.oneTo(SIZE));
    private final MutableList<Integer> integersEC = Interval.oneTo(SIZE).toList();

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
    public int serial_lazy_jdk()
    {
        return this.integersJDK.stream().min(Comparator.naturalOrder()).get();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int serial_lazy_streams_ec()
    {
        return this.integersEC.stream().min(Comparator.naturalOrder()).get();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int serial_lazy_reverse_jdk()
    {
        return this.integersJDK.stream().min(Comparator.reverseOrder()).get();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int serial_lazy_reverse_streams_ec()
    {
        return this.integersEC.stream().min(Comparator.reverseOrder()).get();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int serial_lazy_intstream_jdk()
    {
        return this.integersJDK.stream().mapToInt(Integer::intValue).min().getAsInt();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int serial_lazy_intstream_streams_ec()
    {
        return this.integersEC.stream().mapToInt(Integer::intValue).min().getAsInt();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int parallel_lazy_jdk()
    {
        return this.integersJDK.parallelStream().min(Comparator.naturalOrder()).get();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int parallel_lazy_streams_ec()
    {
        return this.integersEC.parallelStream().min(Comparator.naturalOrder()).get();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int parallel_lazy_reverse_jdk()
    {
        return this.integersJDK.parallelStream().min(Comparator.reverseOrder()).get();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int parallel_lazy_reverse_streams_ec()
    {
        return this.integersEC.parallelStream().min(Comparator.reverseOrder()).get();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int parallel_lazy_intstream_jdk()
    {
        return this.integersJDK.parallelStream().mapToInt(Integer::intValue).min().getAsInt();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int parallel_lazy_intstream_streams_ec()
    {
        return this.integersEC.parallelStream().mapToInt(Integer::intValue).min().getAsInt();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int serial_eager_ec()
    {
        return this.integersEC.min(Comparator.naturalOrder());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int serial_eager_reverse_ec()
    {
        return this.integersEC.min(Comparator.reverseOrder());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int serial_lazy_ec()
    {
        return this.integersEC.asLazy().min(Comparator.naturalOrder());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int serial_lazy_reverse_ec()
    {
        return this.integersEC.asLazy().min(Comparator.reverseOrder());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int parallel_lazy_ec()
    {
        return this.integersEC.asParallel(this.executorService, BATCH_SIZE).min(Comparator.naturalOrder());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public int parallel_lazy_reverse_ec()
    {
        return this.integersEC.asParallel(this.executorService, BATCH_SIZE).min(Comparator.reverseOrder());
    }
}
