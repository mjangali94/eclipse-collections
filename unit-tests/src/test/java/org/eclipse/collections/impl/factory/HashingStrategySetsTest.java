/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.factory;

import org.eclipse.collections.api.factory.set.strategy.ImmutableHashingStrategySetFactory;
import org.eclipse.collections.api.factory.set.strategy.MutableHashingStrategySetFactory;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.strategy.mutable.UnifiedSetWithHashingStrategy;
import org.eclipse.collections.impl.test.Verify;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.rules.TestName;
import org.eclipse.collections.impl.myBlackhole;
import org.junit.Assert;
import org.junit.Test;

public class HashingStrategySetsTest
{
        public @org.junit.Rule TestName name = new TestName();
        @org.junit.Before
    public void myBefore() throws IOException {
    	FileWriter fw = new FileWriter("/Users/massi/Desktop/tmp.csv", true);
     try{    	fw.write(this.getClass().getName()+"."+name.getMethodName() +","+org.eclipse.collections.impl.myBlackhole.hitting_count()+"\n");
     }catch(Exception e){}    	fw.close();
    }
@Test
    public void immutable()
    {
        ImmutableHashingStrategySetFactory factory = HashingStrategySets.immutable;
        Assert.assertEquals(UnifiedSet.newSet(), factory.of(HashingStrategies.defaultStrategy()));
        Verify.assertInstanceOf(ImmutableSet.class, factory.of(HashingStrategies.defaultStrategy()));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2), factory.of(HashingStrategies.defaultStrategy(), 1, 2));
        Verify.assertInstanceOf(ImmutableSet.class, factory.of(HashingStrategies.defaultStrategy(), 1, 2));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4), factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4));
        Verify.assertInstanceOf(ImmutableSet.class, factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4, 5, 6), factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4, 5, 6));
        Verify.assertInstanceOf(ImmutableSet.class, factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4, 5, 6));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4, 5, 6, 7, 8), factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4, 5, 6, 7, 8));
        Verify.assertInstanceOf(ImmutableSet.class, factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(UnifiedSet.newSetWith(), factory.of(HashingStrategies.defaultStrategy(), null));
        Verify.assertInstanceOf(ImmutableSet.class, factory.of(HashingStrategies.defaultStrategy(), null));
        Assert.assertEquals(UnifiedSetWithHashingStrategy.newSet(HashingStrategies.defaultStrategy(), 1), factory.ofInitialCapacity(HashingStrategies.defaultStrategy(), 1));
        Verify.assertInstanceOf(ImmutableSet.class, factory.ofInitialCapacity(HashingStrategies.defaultStrategy(), 1));
        Assert.assertEquals(UnifiedSetWithHashingStrategy.newSet(HashingStrategies.defaultStrategy(), 3), factory.withInitialCapacity(HashingStrategies.defaultStrategy(), 3));
        Verify.assertInstanceOf(ImmutableSet.class, factory.ofInitialCapacity(HashingStrategies.defaultStrategy(), 3));
    }

    @Test
    public void mutable()
    {
        MutableHashingStrategySetFactory factory = HashingStrategySets.mutable;
        Assert.assertEquals(UnifiedSet.newSet(), factory.of(HashingStrategies.defaultStrategy()));
        Verify.assertInstanceOf(MutableSet.class, factory.of(HashingStrategies.defaultStrategy()));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2), factory.of(HashingStrategies.defaultStrategy(), 1, 2));
        Verify.assertInstanceOf(MutableSet.class, factory.of(HashingStrategies.defaultStrategy(), 1, 2));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4), factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4));
        Verify.assertInstanceOf(MutableSet.class, factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4, 5, 6), factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4, 5, 6));
        Verify.assertInstanceOf(MutableSet.class, factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4, 5, 6));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4, 5, 6, 7, 8), factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4, 5, 6, 7, 8));
        Verify.assertInstanceOf(MutableSet.class, factory.of(HashingStrategies.defaultStrategy(), 1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4, 5, 6, 7, 8), factory.ofAll(HashingStrategies.defaultStrategy(), FastList.newListWith(1, 2, 3, 4, 5, 6, 7, 8)));
        Verify.assertInstanceOf(MutableSet.class, factory.of(HashingStrategies.defaultStrategy(), FastList.newListWith(1, 2, 3, 4, 5, 6, 7, 8)));
        Assert.assertEquals(UnifiedSetWithHashingStrategy.newSet(HashingStrategies.defaultStrategy(), 1), factory.ofInitialCapacity(HashingStrategies.defaultStrategy(), 1));
        Verify.assertInstanceOf(MutableSet.class, factory.ofInitialCapacity(HashingStrategies.defaultStrategy(), 1));
        Assert.assertEquals(UnifiedSetWithHashingStrategy.newSet(HashingStrategies.defaultStrategy(), 3), factory.withInitialCapacity(HashingStrategies.defaultStrategy(), 3));
        Verify.assertInstanceOf(MutableSet.class, factory.ofInitialCapacity(HashingStrategies.defaultStrategy(), 3));
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(HashingStrategySets.class);
    }
}
