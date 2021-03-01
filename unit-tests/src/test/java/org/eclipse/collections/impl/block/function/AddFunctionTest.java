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

import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.impl.test.Verify;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.rules.TestName;
import org.eclipse.collections.impl.myBlackhole;
import org.junit.Assert;
import org.junit.Test;

// This class is not a full test of AddFunction at present, but serves as a
// holder for the addStringBlockHandlesNulls() test which had been put in the
// BlocksTest class erroneously. The BlocksTest class has since been removed.
public class AddFunctionTest
{
        public @org.junit.Rule TestName name = new TestName();
        @org.junit.Before
    public void myBefore() throws IOException {
    	FileWriter fw = new FileWriter("/Users/massi/Desktop/tmp.csv", true);
     try{    	fw.write(this.getClass().getName()+"."+name.getMethodName() +","+org.eclipse.collections.impl.myBlackhole.hitting_count()+"\n");
     }catch(Exception e){}    	fw.close();
    }
@Test
    public void addStringBlockHandlesNulls()
    {
        Function2<String, String, String> undertest = AddFunction.STRING;
        Assert.assertEquals("two", undertest.value(null, "two"));
        Assert.assertEquals("one", undertest.value("one", null));
    }

    @Test
    public void addLongFunction()
    {
        Function2<Long, Long, Long> longFunction = AddFunction.LONG;
        Assert.assertEquals(Long.valueOf(3L), longFunction.value(1L, 2L));
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(AddFunction.class);
    }
}
