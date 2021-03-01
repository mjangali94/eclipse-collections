/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.list.immutable.primitive;

import org.eclipse.collections.api.list.primitive.ImmutableBooleanList;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.rules.TestName;
import org.eclipse.collections.impl.myBlackhole;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableBooleanSingletonListTest extends AbstractImmutableBooleanListTestCase
{
    @Override
    protected ImmutableBooleanList classUnderTest()
    {
        return BooleanArrayList.newListWith(true).toImmutable();
    }

    
        public @org.junit.Rule TestName name = new TestName();
        @org.junit.Before
    public void myBefore() throws IOException {
    	FileWriter fw = new FileWriter("/Users/massi/Desktop/tmp.csv", true);
     try{    	fw.write(this.getClass().getName()+"."+name.getMethodName() +","+org.eclipse.collections.impl.myBlackhole.hitting_count()+"\n");
     }catch(Exception e){}    	fw.close();
    }
@Override
@Test
    public void testEquals()
    {
        super.testEquals();
        Assert.assertNotEquals(this.newWith(true), this.newWith());
    }

    @Override
    @Test
    public void toReversed()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex()
    {
        String[] sum = new String[2];
        sum[0] = "";
        this.classUnderTest().forEachWithIndex((each, index) -> sum[0] += index + ":" + each);
        Assert.assertEquals("0:true", sum[0]);
    }
}
