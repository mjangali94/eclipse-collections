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
public class SelectTest 
{
    private static final int SIZE = 1_000_000;
    private static final int BATCH_SIZE = 10_000;
    private final ExecutorService service = ParallelIterate.newPooledExecutor(SelectTest.class.getSimpleName(), true);
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
        List<Integer> evens = this.integersJDK.stream().filter(each -> each % 2 == 0).collect(Collectors.toList());
        Assert.assertEquals(SIZE / 2, evens.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void serial_lazy_streams_ec()
    {
        List<Integer> evens = this.integersEC.stream().filter(each -> each % 2 == 0).collect(Collectors.toList());
        Assert.assertEquals(SIZE / 2, evens.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void parallel_lazy_jdk()
    {
        List<Integer> evens = this.integersJDK.parallelStream().filter(each -> each % 2 == 0).collect(Collectors.toList());
        Assert.assertEquals(SIZE / 2, evens.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void parallel_lazy_streams_ec()
    {
        List<Integer> evens = this.integersEC.parallelStream().filter(each -> each % 2 == 0).collect(Collectors.toList());
        Assert.assertEquals(SIZE / 2, evens.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void serial_eager_ec()
    {
        MutableList<Integer> evens = this.integersEC.select(each -> each % 2 == 0);
        Assert.assertEquals(SIZE / 2, evens.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void parallel_eager_ec()
    {
        Collection<Integer> evens = ParallelIterate.select(this.integersEC, each -> each % 2 == 0);
        Assert.assertEquals(SIZE / 2, evens.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void serial_lazy_ec()
    {
        MutableList<Integer> evens = this.integersEC.asLazy().select(each -> each % 2 == 0).toList();
        Assert.assertEquals(SIZE / 2, evens.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void parallel_lazy_ec()
    {
        ParallelListIterable<Integer> parallelListIterable = this.integersEC.asParallel(this.service, BATCH_SIZE);
        MutableList<Integer> evens = parallelListIterable.select(each -> each % 2 == 0).toList();
        Assert.assertEquals(SIZE / 2, evens.size());
    }
}
