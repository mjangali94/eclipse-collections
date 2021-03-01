/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.block.function;

import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.list.mutable.FastList;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.rules.TestName;
import org.eclipse.collections.impl.myBlackhole;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link MinSizeFunction}.
 */
public class MinSizeFunctionTest
{
        public @org.junit.Rule TestName name = new TestName();
        @org.junit.Before
    public void myBefore() throws IOException {
    	FileWriter fw = new FileWriter("/Users/massi/Desktop/tmp.csv", true);
     try{    	fw.write(this.getClass().getName()+"."+name.getMethodName() +","+org.eclipse.collections.impl.myBlackhole.hitting_count()+"\n");
     }catch(Exception e){}    	fw.close();
    }
@Test
    public void minSizeCollection()
    {
        Assert.assertEquals(Integer.valueOf(2), MinSizeFunction.COLLECTION.value(2, FastList.newListWith(1, 2, 3)));
        Assert.assertEquals(Integer.valueOf(2), MinSizeFunction.COLLECTION.value(3, FastList.newListWith(1, 2)));
    }

    @Test
    public void minSizeMap()
    {
        Assert.assertEquals(Integer.valueOf(2), MinSizeFunction.MAP.value(2, Maps.mutable.of(1, 1, 2, 2, 3, 3)));
        Assert.assertEquals(Integer.valueOf(2), MinSizeFunction.MAP.value(3, Maps.mutable.of(1, 1, 2, 2)));
    }
}
