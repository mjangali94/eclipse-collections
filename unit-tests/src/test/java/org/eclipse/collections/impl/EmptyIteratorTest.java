/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl;

import java.util.NoSuchElementException;

import java.io.FileWriter;
import java.io.IOException;
import org.junit.rules.TestName;
import org.eclipse.collections.impl.myBlackhole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmptyIteratorTest
{
    private EmptyIterator<Object> emptyIterator;

    @Before
    public void setUp()
    {
        this.emptyIterator = EmptyIterator.getInstance();
    }

        public @org.junit.Rule TestName name = new TestName();
        @org.junit.Before
    public void myBefore() throws IOException {
    	FileWriter fw = new FileWriter("/Users/massi/Desktop/tmp.csv", true);
     try{    	fw.write(this.getClass().getName()+"."+name.getMethodName() +","+org.eclipse.collections.impl.myBlackhole.hitting_count()+"\n");
     }catch(Exception e){}    	fw.close();
    }
@Test
    public void hasPrevious()
    {
        Assert.assertFalse(this.emptyIterator.hasPrevious());
    }

    @Test
    public void previous()
    {
        Assert.assertThrows(NoSuchElementException.class, this.emptyIterator::previous);
    }

    @Test
    public void previousIndex()
    {
        Assert.assertEquals(-1, this.emptyIterator.previousIndex());
    }

    @Test
    public void set()
    {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.emptyIterator.set(1));
    }

    @Test
    public void add()
    {
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.emptyIterator.add(1));
    }
}
