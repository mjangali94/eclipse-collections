/*
 * Copyright (c) 2017 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.block.function.primitive;

import org.eclipse.collections.impl.test.Verify;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.rules.TestName;
import org.eclipse.collections.impl.myBlackhole;
import org.junit.Assert;
import org.junit.Test;

public class BooleanCaseFunctionTest
{
        public @org.junit.Rule TestName name = new TestName();
        @org.junit.Before
    public void myBefore() throws IOException {
    	FileWriter fw = new FileWriter("/Users/massi/Desktop/tmp.csv", true);
     try{    	fw.write(this.getClass().getName()+"."+name.getMethodName() +","+org.eclipse.collections.impl.myBlackhole.hitting_count()+"\n");
     }catch(Exception e){}    	fw.close();
    }
@Test
    public void noopCase()
    {
        BooleanCaseFunction<Boolean> function = new BooleanCaseFunction<>();
        Assert.assertNull(function.valueOf(true));
    }

    @Test
    public void basicCase()
    {
        BooleanCaseFunction<Boolean> function = new BooleanCaseFunction<>();
        function.addCase(value -> value, Boolean::valueOf);
        Assert.assertEquals(Boolean.valueOf(true), function.valueOf(true));
    }

    @Test
    public void defaultValue()
    {
        BooleanCaseFunction<String> function = new BooleanCaseFunction<>(e -> "Yow!")
                .addCase(e -> e, e -> "Patience, grasshopper");

        Assert.assertEquals("Yow!", function.valueOf(false));

        function.setDefault(i -> "Patience, young grasshopper");
        Assert.assertEquals("Patience, grasshopper", function.valueOf(true));
        Assert.assertEquals("Patience, young grasshopper", function.valueOf(false));

        Verify.assertContains("BooleanCaseFunction", function.toString());
    }
}
