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
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.google.common.collect.Multimaps;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.myBlackhole;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.openjdk.jmh.annotations.*;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class GroupByListTest 
{
    private static final int SIZE = 1_000_000;
    private final List<Integer> integersJDK = new ArrayList<>(Interval.oneTo(SIZE));
    private final MutableList<Integer> integersEC = Interval.oneTo(SIZE).toList();
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
    public void groupBy_2_keys_serial_lazy_jdk()
    {
        Verify.assertSize(2, this.integersJDK.stream().collect(Collectors.groupingBy(each -> each % 2 == 0)));
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_2_keys_serial_lazy_streams_ec()
    {
        Verify.assertSize(2, this.integersEC.stream().collect(Collectors.groupingBy(each -> each % 2 == 0)));
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_100_keys_serial_lazy_jdk()
    {
        Verify.assertSize(100, this.integersJDK.stream().collect(Collectors.groupingBy(each -> each % 100)));
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_100_keys_serial_lazy_streams_ec()
    {
        Verify.assertSize(100, this.integersEC.stream().collect(Collectors.groupingBy(each -> each % 100)));
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_10000_keys_serial_lazy_jdk()
    {
        Verify.assertSize(10_000, this.integersJDK.stream().collect(Collectors.groupingBy(each -> each % 10_000)));
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_10000_keys_serial_lazy_streams_ec()
    {
        Verify.assertSize(10_000, this.integersEC.stream().collect(Collectors.groupingBy(each -> each % 10_000)));
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_2_keys_serial_eager_guava()
    {
        Verify.assertSize(2, Multimaps.index(this.integersJDK, each -> each % 2 == 0).asMap());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_100_keys_serial_eager_guava()
    {
        Verify.assertSize(100, Multimaps.index(this.integersJDK, each -> each % 100).asMap());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_10000_keys_serial_eager_guava()
    {
        Verify.assertSize(10_000, Multimaps.index(this.integersJDK, each -> each % 10000).asMap());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_2_keys_serial_eager_ec()
    {
        Assert.assertEquals(2, this.integersEC.groupBy(each -> each % 2 == 0).sizeDistinct());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_100_keys_serial_eager_ec()
    {
        Assert.assertEquals(100, this.integersEC.groupBy(each -> each % 100).sizeDistinct());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_10000_keys_serial_eager_ec()
    {
        Assert.assertEquals(10_000, this.integersEC.groupBy(each -> each % 10_000).sizeDistinct());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_2_keys_serial_lazy_ec()
    {
        Assert.assertEquals(2, this.integersEC.asLazy().groupBy(each -> each % 2 == 0).sizeDistinct());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_100_keys_serial_lazy_ec()
    {
        Assert.assertEquals(100, this.integersEC.asLazy().groupBy(each -> each % 100).sizeDistinct());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_10000_keys_serial_lazy_ec()
    {
        Assert.assertEquals(10_000, this.integersEC.asLazy().groupBy(each -> each % 10_000).sizeDistinct());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_2_keys_serial_eager_scala()
    {
        GroupByScalaTest.groupBy_2_keys_serial_eager_scala();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_100_keys_serial_eager_scala()
    {
        GroupByScalaTest.groupBy_100_keys_serial_eager_scala();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_10000_keys_serial_eager_scala()
    {
        GroupByScalaTest.groupBy_10000_keys_serial_eager_scala();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_2_keys_serial_lazy_scala()
    {
        GroupByScalaTest.groupBy_2_keys_serial_lazy_scala();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_100_keys_serial_lazy_scala()
    {
        GroupByScalaTest.groupBy_100_keys_serial_lazy_scala();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void groupBy_10000_keys_serial_lazy_scala()
    {
        GroupByScalaTest.groupBy_10000_keys_serial_lazy_scala();
    }
}
