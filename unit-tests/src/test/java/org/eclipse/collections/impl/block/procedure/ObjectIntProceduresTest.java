/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.block.procedure;

import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.ObjectIntProcedures;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.rules.TestName;
import org.eclipse.collections.impl.myBlackhole;
import org.junit.Assert;
import org.junit.Test;

public class ObjectIntProceduresTest
{
        public @org.junit.Rule TestName name = new TestName();
        @org.junit.Before
    public void myBefore() throws IOException {
    	FileWriter fw = new FileWriter("/Users/massi/Desktop/tmp.csv", true);
     try{    	fw.write(this.getClass().getName()+"."+name.getMethodName() +","+org.eclipse.collections.impl.myBlackhole.hitting_count()+"\n");
     }catch(Exception e){}    	fw.close();
    }
@Test
    public void fromObjectIntProcedure()
    {
        MutableList<Integer> result = FastList.newList();
        ObjectIntProcedure<Integer> objectIntProcedure = ObjectIntProcedures.fromProcedure(result::add);
        objectIntProcedure.value(1, 0);
        Assert.assertEquals(FastList.newListWith(1), result);
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ObjectIntProcedures.class);
    }
}
