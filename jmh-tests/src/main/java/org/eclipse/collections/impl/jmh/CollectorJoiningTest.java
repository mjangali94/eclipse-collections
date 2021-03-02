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
public class CollectorJoiningTest 
{
    private static final int SIZE = 25;
    private static final int BATCH_SIZE = 5;
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
    public String serial_lazy_mapToStringJoining_jdk()
    {
        return this.integersJDK.stream().map(Object::toString).collect(Collectors.joining(","));
    }

    @Benchmark @OperationsPerInvocation(1) 
    public String serial_lazy_mapToStringJoining_ec()
    {
        return this.integersEC.stream().map(Object::toString).collect(Collectors.joining(","));
    }

    @Benchmark @OperationsPerInvocation(1) 
    public String parallel_lazy_mapToStringJoining_jdk()
    {
        return this.integersJDK.parallelStream().map(Object::toString).collect(Collectors.joining(","));
    }

    @Benchmark @OperationsPerInvocation(1) 
    public String parallel_lazy_mapToStringJoining_ec()
    {
        return this.integersEC.parallelStream().map(Object::toString).collect(Collectors.joining(","));
    }

    @Benchmark @OperationsPerInvocation(1) 
    public String serial_eager_collectToStringJoining_ec()
    {
        return this.integersEC.collect(Object::toString).reduceInPlace(Collectors.joining(","));
    }

    @Benchmark @OperationsPerInvocation(1) 
    public String serial_lazy_collectToStringJoining_ec()
    {
        return this.integersEC.asLazy().collect(Object::toString).reduceInPlace(Collectors.joining(","));
    }

    @Benchmark @OperationsPerInvocation(1) 
    public String serial_eager_makeString_ec()
    {
        return this.integersEC.makeString(",");
    }

    @Benchmark @OperationsPerInvocation(1) 
    public String parallel_lazy_makeString_ec()
    {
        return this.integersEC.asParallel(this.executorService, BATCH_SIZE).makeString(",");
    }

    @Benchmark @OperationsPerInvocation(1) 
    public String serial_eager_primitiveMakeString_ec()
    {
        return this.intList.makeString(",");
    }
}
