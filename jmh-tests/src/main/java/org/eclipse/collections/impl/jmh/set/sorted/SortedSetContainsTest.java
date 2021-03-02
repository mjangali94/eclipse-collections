/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.jmh.set.sorted;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.myBlackhole;
import org.eclipse.collections.impl.factory.SortedSets;
import org.eclipse.collections.impl.list.Interval;
import org.openjdk.jmh.annotations.*;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class SortedSetContainsTest
{
    private static final int SIZE = 2_000_000;

    private final MutableSortedSet<Integer> ecMutable = SortedSets.mutable.withAll(Interval.zeroToBy(SIZE, 2));
    private final ImmutableSortedSet<Integer> ecImmutable = SortedSets.immutable.withAll(Interval.zeroToBy(SIZE, 2));
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
    public void contains_mutable_ec()
    {
        int size = SIZE;
        MutableSortedSet<Integer> localEcMutable = this.ecMutable;

        for (int i = 0; i < size; i += 2)
        {
            if (!localEcMutable.contains(i))
            {
                throw new AssertionError(i);
            }
        }

        for (int i = 1; i < size; i += 2)
        {
            if (localEcMutable.contains(i))
            {
                throw new AssertionError(i);
            }
        }
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void contains_immutable_ec()
    {
        int size = SIZE;
        ImmutableSortedSet<Integer> localEcImmutable = this.ecImmutable;

        for (int i = 0; i < size; i += 2)
        {
            if (!localEcImmutable.contains(i))
            {
                throw new AssertionError(i);
            }
        }

        for (int i = 1; i < size; i += 2)
        {
            if (localEcImmutable.contains(i))
            {
                throw new AssertionError(i);
            }
        }
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void contains_mutable_scala()
    {
        SortedSetContainsScalaTest.contains_mutable_scala();
    }

    @Benchmark @OperationsPerInvocation(1) 
    public void contains_immutable_scala()
    {
        SortedSetContainsScalaTest.contains_immutable_scala();
    }
}
