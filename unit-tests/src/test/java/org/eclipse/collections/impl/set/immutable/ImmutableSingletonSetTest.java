/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.immutable;

import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.set.ImmutableSet;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.rules.TestName;
import org.eclipse.collections.impl.myBlackhole;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableSingletonSetTest
        extends AbstractImmutableSetTestCase
{
    @Override
    protected ImmutableSet<Integer> classUnderTest()
    {
        return new ImmutableSingletonSet<>(1);
    }

        public @org.junit.Rule TestName name = new TestName();
        @org.junit.Before
    public void myBefore() throws IOException {
    	FileWriter fw = new FileWriter("/Users/massi/Desktop/tmp.csv", true);
     try{    	fw.write(this.getClass().getName()+"."+name.getMethodName() +","+org.eclipse.collections.impl.myBlackhole.hitting_count()+"\n");
     }catch(Exception e){}    	fw.close();
    }
@Test
    @Override
    public void min_null_throws()
    {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        super.min_null_throws();
    }

    @Test
    @Override
    public void max_null_throws()
    {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        super.max_null_throws();
    }

    @Test
    @Override
    public void min_null_throws_without_comparator()
    {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        super.min_null_throws_without_comparator();
    }

    @Test
    @Override
    public void max_null_throws_without_comparator()
    {
        // Collections with one element should not throw to emulate the JDK Collections behavior
        super.max_null_throws_without_comparator();
    }

    @Test
    public void getOnly()
    {
        ImmutableCollection<Integer> integers = this.classUnderTest();
        Assert.assertEquals(Integer.valueOf(1), integers.getOnly());
    }
}
