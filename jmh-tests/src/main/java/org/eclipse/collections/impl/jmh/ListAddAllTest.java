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

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.myBlackhole;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.openjdk.jmh.annotations.*;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class ListAddAllTest 
{
    private static final int SIZE = 1000;
    private final List<Integer> integersJDK = new ArrayList<>(Interval.oneTo(SIZE));
    private final MutableList<Integer> integersEC = FastList.newList(Interval.oneTo(SIZE));
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
    public void jdk()
    {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1000; i++)
        {
            result.addAll(this.integersJDK);
        }
        if (result.size() != 1_000_000)
        {
            throw new AssertionError();
        }
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void ec()
    {
        MutableList<Integer> result = FastList.newList();
        for (int i = 0; i < 1000; i++)
        {
            result.addAll(this.integersEC);
        }
        if (result.size() != 1_000_000)
        {
            throw new AssertionError();
        }
    }
}
