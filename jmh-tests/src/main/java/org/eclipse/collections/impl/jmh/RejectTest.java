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
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.myBlackhole;
import org.eclipse.collections.impl.block.factory.Predicates;

import org.eclipse.collections.impl.list.Interval;
import org.junit.Assert;
import org.openjdk.jmh.annotations.*;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class RejectTest 
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
    public void serial_lazy_jdk_lambda_not()
    {
        List<Integer> evens = this.integersJDK.stream().filter(each -> each % 2 != 1).collect(Collectors.toList());
        List<Integer> odds = this.integersJDK.stream().filter(each -> each % 2 != 0).collect(Collectors.toList());
        Assert.assertEquals(SIZE / 2, evens.size());
        Assert.assertEquals(SIZE / 2, odds.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void serial_lazy_streams_ec_lambda_not()
    {
        List<Integer> evens = this.integersEC.stream().filter(each -> each % 2 != 1).collect(Collectors.toList());
        List<Integer> odds = this.integersEC.stream().filter(each -> each % 2 != 0).collect(Collectors.toList());
        Assert.assertEquals(SIZE / 2, evens.size());
        Assert.assertEquals(SIZE / 2, odds.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void serial_lazy_jdk_lambda_negate()
    {
        Predicate<Integer> predicate1 = each -> each % 2 == 1;
        List<Integer> evens = this.integersJDK.stream().filter(predicate1.negate()).collect(Collectors.toList());
        Predicate<Integer> predicate2 = each -> each % 2 == 0;
        List<Integer> odds = this.integersJDK.stream().filter(predicate2.negate()).collect(Collectors.toList());
        Assert.assertEquals(SIZE / 2, evens.size());
        Assert.assertEquals(SIZE / 2, odds.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void serial_lazy_streams_ec_lambda_negate()
    {
        Predicate<Integer> predicate1 = each -> each % 2 == 1;
        List<Integer> evens = this.integersEC.stream().filter(predicate1.negate()).collect(Collectors.toList());
        Predicate<Integer> predicate2 = each -> each % 2 == 0;
        List<Integer> odds = this.integersEC.stream().filter(predicate2.negate()).collect(Collectors.toList());
        Assert.assertEquals(SIZE / 2, evens.size());
        Assert.assertEquals(SIZE / 2, odds.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void serial_eager_ec_select_predicates_not()
    {
        MutableList<Integer> evens = this.integersEC.select(Predicates.not(each -> each % 2 == 1));
        MutableList<Integer> odds = this.integersEC.select(Predicates.not(each -> each % 2 == 0));
        Assert.assertEquals(SIZE / 2, evens.size());
        Assert.assertEquals(SIZE / 2, odds.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void serial_eager_ec()
    {
        MutableList<Integer> evens = this.integersEC.reject(each -> each % 2 == 1);
        MutableList<Integer> odds = this.integersEC.reject(each -> each % 2 == 0);
        Assert.assertEquals(SIZE / 2, evens.size());
        Assert.assertEquals(SIZE / 2, odds.size());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void serial_lazy_ec()
    {
        MutableList<Integer> evens = this.integersEC.asLazy().reject(each -> each % 2 == 1).toList();
        MutableList<Integer> odds = this.integersEC.asLazy().reject(each -> each % 2 == 0).toList();
        Assert.assertEquals(SIZE / 2, evens.size());
        Assert.assertEquals(SIZE / 2, odds.size());
    }
}
