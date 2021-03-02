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

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.ParallelListIterable;
import org.eclipse.collections.impl.myBlackhole;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.parallel.ParallelIterate;
import org.junit.Assert;
import org.openjdk.jmh.annotations.*;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class CollectIfTest 
{
    private static final int SIZE = 1_000_000;
    private static final int BATCH_SIZE = 10_000;
    private final ExecutorService service = ParallelIterate.newPooledExecutor(CollectTest.class.getSimpleName(), true);
    private final List<Integer> integersJDK = new ArrayList<>(Interval.oneTo(SIZE));
    private final FastList<Integer> integersEC = FastList.newList(Interval.oneTo(SIZE));
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
    @Benchmark @OperationsPerInvocation(1) 
    public void serial_lazy_jdk()
    {
        List<String> evenStrings = this.integersJDK.stream().filter(e -> e % 2 == 0).map(Object::toString).collect(Collectors.toList());
        List<String> oddStrings = this.integersJDK.stream().filter(e -> e % 2 == 1).map(Object::toString).collect(Collectors.toList());
        Assert.assertEquals(SIZE / 2, evenStrings.size());
        Assert.assertEquals(SIZE / 2, oddStrings.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void serial_lazy_streams_ec()
    {
        List<String> evenStrings = this.integersEC.stream().filter(e -> e % 2 == 0).map(Object::toString).collect(Collectors.toList());
        List<String> oddStrings = this.integersEC.stream().filter(e -> e % 2 == 1).map(Object::toString).collect(Collectors.toList());
        Assert.assertEquals(SIZE / 2, evenStrings.size());
        Assert.assertEquals(SIZE / 2, oddStrings.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void parallel_lazy_jdk()
    {
        List<String> evenStrings = this.integersJDK.parallelStream().filter(e -> e % 2 == 0).map(Object::toString).collect(Collectors.toList());
        List<String> oddStrings = this.integersJDK.parallelStream().filter(e -> e % 2 == 1).map(Object::toString).collect(Collectors.toList());
        Assert.assertEquals(SIZE / 2, evenStrings.size());
        Assert.assertEquals(SIZE / 2, oddStrings.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void parallel_lazy_streams_ec()
    {
        List<String> evenStrings = this.integersEC.parallelStream().filter(e -> e % 2 == 0).map(Object::toString).collect(Collectors.toList());
        List<String> oddStrings = this.integersEC.parallelStream().filter(e -> e % 2 == 1).map(Object::toString).collect(Collectors.toList());
        Assert.assertEquals(SIZE / 2, evenStrings.size());
        Assert.assertEquals(SIZE / 2, oddStrings.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void serial_eager_ec()
    {
        MutableList<String> evenStrings = this.integersEC.collectIf(e -> e % 2 == 0, Object::toString);
        MutableList<String> oddStrings = this.integersEC.collectIf(e -> e % 2 == 1, Object::toString);
        Assert.assertEquals(SIZE / 2, evenStrings.size());
        Assert.assertEquals(SIZE / 2, oddStrings.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void parallel_eager_ec()
    {
        Collection<String> evenStrings = ParallelIterate.collectIf(this.integersEC, e -> e % 2 == 0, Object::toString);
        Collection<String> oddStrings = ParallelIterate.collectIf(this.integersEC, e -> e % 2 == 1, Object::toString);
        Assert.assertEquals(SIZE / 2, evenStrings.size());
        Assert.assertEquals(SIZE / 2, oddStrings.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void serial_lazy_ec()
    {
        MutableList<String> evenStrings = this.integersEC.asLazy().select(e -> e % 2 == 0).collect(Object::toString).toList();
        MutableList<String> oddStrings = this.integersEC.asLazy().select(e -> e % 2 == 1).collect(Object::toString).toList();
        Assert.assertEquals(SIZE / 2, evenStrings.size());
        Assert.assertEquals(SIZE / 2, oddStrings.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void parallel_lazy_ec()
    {
        ParallelListIterable<Integer> parallelListIterable = this.integersEC.asParallel(this.service, BATCH_SIZE);
        MutableList<String> evenStrings = parallelListIterable.select(e -> e % 2 == 0).collect(Object::toString).toList();
        MutableList<String> oddStrings = parallelListIterable.select(e -> e % 2 == 1).collect(Object::toString).toList();
        Assert.assertEquals(SIZE / 2, evenStrings.size());
        Assert.assertEquals(SIZE / 2, oddStrings.size());
    }
}
