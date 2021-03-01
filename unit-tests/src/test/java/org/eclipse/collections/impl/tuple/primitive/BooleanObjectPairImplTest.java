/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.tuple.primitive;

import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.rules.TestName;
import org.eclipse.collections.impl.myBlackhole;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link BooleanBooleanPairImpl}.
 */
public class BooleanObjectPairImplTest
{
        public @org.junit.Rule TestName name = new TestName();
        @org.junit.Before
    public void myBefore() throws IOException {
    	FileWriter fw = new FileWriter("/Users/massi/Desktop/tmp.csv", true);
     try{    	fw.write(this.getClass().getName()+"."+name.getMethodName() +","+org.eclipse.collections.impl.myBlackhole.hitting_count()+"\n");
     }catch(Exception e){}    	fw.close();
    }
@Test
    public void testEqualsAndHashCode()
    {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(true, "false"), PrimitiveTuples.pair(true, "false"));
        Assert.assertNotEquals(PrimitiveTuples.pair(false, "true"), PrimitiveTuples.pair(true, "false"));
        Assert.assertEquals(Tuples.pair(true, "false").hashCode(), PrimitiveTuples.pair(true, "false").hashCode());
    }

    @Test
    public void getOne()
    {
        Assert.assertTrue(PrimitiveTuples.pair(true, "false").getOne());
        Assert.assertFalse(PrimitiveTuples.pair(false, "true").getOne());
    }

    @Test
    public void getTwo()
    {
        Assert.assertEquals("true", PrimitiveTuples.pair(false, "true").getTwo());
        Assert.assertEquals("false", PrimitiveTuples.pair(true, "false").getTwo());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("true:false", PrimitiveTuples.pair(true, "false").toString());
        Assert.assertEquals("true:true", PrimitiveTuples.pair(true, "true").toString());
    }

    @Test
    public void compareTo()
    {
        Assert.assertEquals(1, PrimitiveTuples.pair(true, "false").compareTo(PrimitiveTuples.pair(false, "false")));
        Assert.assertEquals(0, PrimitiveTuples.pair(true, "false").compareTo(PrimitiveTuples.pair(true, "false")));
        Assert.assertEquals(-1, PrimitiveTuples.pair(false, "false").compareTo(PrimitiveTuples.pair(true, "true")));
    }
}
