/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.lazy.parallel.set;

import org.eclipse.collections.api.ParallelIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.MultiReaderHashBag;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.lazy.parallel.ParallelIterableTestCase;
import org.eclipse.collections.impl.set.mutable.MultiReaderUnifiedSet;
import java.io.FileWriter;
import java.io.IOException;
import org.eclipse.collections.impl.PerformanceLogger;
import org.junit.Assert;
import org.junit.Test;

public class ParallelCollectMultiReaderSetIterableTest extends ParallelIterableTestCase
{
    @Override
    protected ParallelIterable<Integer> classUnderTest()
    {
        return this.newWith(44, 43, 42, 41, 33, 32, 31, 22, 21, 11);
    }

    @Override
    protected ParallelIterable<Integer> newWith(Integer... littleElements)
    {
        return MultiReaderUnifiedSet.newSetWith(littleElements)
                .asParallel(this.executorService, this.batchSize)
                .collect(i -> i / 10);
    }

    @Override
    protected MutableBag<Integer> getExpected()
    {
        return HashBag.newBagWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    }

    @Override
    protected MutableBag<Integer> getExpectedWith(Integer... littleElements)
    {
        return MultiReaderHashBag.newBagWith(littleElements)
                .collect(i -> i / 10);
    }

    @Override
    protected boolean isOrdered()
    {
        return false;
    }

    @Override
    protected boolean isUnique()
    {
        return false;
    }

    @org.junit.Rule public PerformanceLogger name = new PerformanceLogger();
@Test
    @Override
    public void groupBy()
    {
        Function<Integer, Boolean> isOddFunction = object -> IntegerPredicates.isOdd().accept(object);

        Assert.assertEquals(
                this.getExpected().toBag().groupBy(isOddFunction),
                this.classUnderTest().groupBy(isOddFunction));
    }

    @Test
    @Override
    public void groupByEach()
    {
        Assert.assertEquals(
                this.getExpected().toBag().groupByEach(new NegativeIntervalFunction()),
                this.classUnderTest().groupByEach(new NegativeIntervalFunction()));
    }
}
