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
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.myBlackhole;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.openjdk.jmh.annotations.*;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class FlatCollectTest 
{
    private static final int COUNT = 10_000;
    private static final int LIST_SIZE = 100;
    private final List<List<Integer>> integersJDK = new ArrayList<>(FastList.<List<Integer>>newWithNValues(COUNT, () -> new ArrayList<>(Interval.oneTo(LIST_SIZE))));
    private final MutableList<MutableList<Integer>> integersEC = FastList.newWithNValues(COUNT, () -> Interval.oneTo(LIST_SIZE).toList());
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
    public List<Integer> serial_lazy_jdk()
    {
        return this.integersJDK.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public List<Integer> serial_lazy_streams_ec()
    {
        return this.integersEC.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Benchmark @OperationsPerInvocation(1) 
    public MutableList<Integer> serial_eager_ec()
    {
        return this.integersEC.flatCollect(e -> e);
    }

    @Benchmark @OperationsPerInvocation(1) 
    public MutableList<Integer> serial_lazy_ec()
    {
        return this.integersEC.asLazy().flatCollect(e -> e).toList();
    }
}
